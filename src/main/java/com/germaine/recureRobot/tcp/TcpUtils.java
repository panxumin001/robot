package com.germaine.recureRobot.tcp;

import java.io.*;
import java.net.*;

public class TcpUtils {
     public static String sendMessege (String host, int port, String message) {
         try {
             //创建Socket对象
             Socket socket = new Socket();
             socket.connect(new InetSocketAddress(host, port), 1800);//设置连接请求超时时间
             socket.setSoTimeout(30000);// 设置读操作超时时间30s

             //根据输入输出流和服务端连接
             System.out.println("--->>client connected to " + socket.getRemoteSocketAddress());
             OutputStream outputStream=socket.getOutputStream();//获取一个输出流，向服务端发送信息
             PrintWriter printWriter=new PrintWriter(outputStream);//将输出流包装成打印流
             printWriter.print(message); // 发送信息
             printWriter.flush();
             socket.shutdownOutput();//关闭输出流

             InputStream inputStream=socket.getInputStream();//获取一个输入流，接收服务端的信息
             InputStreamReader inputStreamReader=new InputStreamReader(inputStream);//包装成字符流，提高效率
             BufferedReader bufferedReader=new BufferedReader(inputStreamReader);//缓冲区
             String info="";
             String temp=null;//临时变量
             while((temp=bufferedReader.readLine())!=null){
                 info+=temp;
                 System.out.println("--->>client receive server info："+info);
             }

             //关闭相对应的资源
             bufferedReader.close();
             inputStream.close();
             printWriter.close();
             outputStream.close();
             socket.close();
             return "order send success";
         } catch (UnknownHostException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
             return e.getMessage();
         }
         return null;
     }

     public static void  createTcpServer(int prot, int backLog, String host) {
         try {
             ServerSocket serverSocket = new ServerSocket(prot, backLog, InetAddress.getByName (host));
             System.out.println("服务端已启动，等待客户端连接..");

             while (true) {
                 Socket socket = serverSocket.accept();// 侦听并接受到此套接字的连接,返回一个Socket对象
                 SocketThread socketThread = new SocketThread(socket);
                 socketThread.start();
             }

         } catch (IOException e) {
             e.printStackTrace();
         }
     }
}
