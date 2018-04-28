package com.germaine.recureRobot;

import org.junit.Test;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.Base64;

public class AESTest {

    private static final String ALGORITHM = "AES";

    /**
     * 生成秘钥
     * @return
     * @throws Exception
     */
    @Test
    public SecretKey geneKey() throws Exception {
        //获取一个密钥生成器实例
        KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
        SecureRandom random = new SecureRandom();
        //设置加密用的种子，密钥
        random.setSeed("123456".getBytes());
        keyGenerator.init(random);
        SecretKey secretKey = keyGenerator.generateKey();
        //把上面的密钥存起来
        Path keyPath = Paths.get("D:/aes.key");
        Files.write(keyPath, secretKey.getEncoded());
        return secretKey;
    }

    /**
     * 读取存储的秘钥
     * @param keyPath
     * @return
     * @throws Exception
     */
    @Test
    public SecretKey readKey(Path keyPath) throws Exception {
        // 读取存储的秘钥
        byte[] keyBytes = Files.readAllBytes(keyPath);
        SecretKeySpec keySpec = new SecretKeySpec(keyBytes, ALGORITHM);
        return keySpec;
    }

    /**
     * 加密
     * @throws Exception
     */
    @Test
    public void encrypt() throws Exception {
        // 指定算法获取Cipher对象
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        // 生成/读取用于加密的秘钥
        SecretKey secretKey = this.geneKey();
        // 用指定的秘钥初始化Cipher对象，指定是加密模式还是解密模式
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        String content = "Hello!!";
        // 更新需要加密的内容
        cipher.update(content.getBytes());
        // 进行最终的加密操作
        byte[] result = cipher.doFinal();
        // 对加密后的字节数组进行Base64编码
        String base64Result = Base64.getEncoder().encodeToString(result);
        System.out.println("Result:" + base64Result);
    }

    /**
     * 解密
     * @throws Exception
     */
    @Test
    public void decrpyt() throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        SecretKey secretKey = this.geneKey();
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        String content = "pK9Xw4zqTMXYraDadSGJE3x/ftrDxIg2AM/acq0uixA=";//经过Base64加密的待解密的内容
        byte[] decodeBytes = Base64.getDecoder().decode(content.getBytes());
        byte[] result = cipher.doFinal(decodeBytes);// 对加密后的字节数组进行解密
        System.out.println("Result: " + new String(result));
    }
}
