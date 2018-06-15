package com.germaine.recureRobot.socket.nio;

import com.alibaba.fastjson.JSON;
import com.germaine.recureRobot.entity.RobotGaitEntity;
import com.germaine.recureRobot.service.RobotGaitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.net.*;
import java.util.Iterator;

public class TcpAsyncServer {

    @Autowired
    private RobotGaitService robotGaitService;

    /*监听端口*/
    int port = 8000;
    /*缓冲区大小*/
    ByteBuffer buffer = ByteBuffer.allocate(1024);
    /*其它相关定义*/
    Selector selector;
    ServerSocketChannel channel;
    ServerSocket socket;

    /*启动*/
    public void Start() throws Exception {
        /*初始化一个Selector*/
        selector = Selector.open();
        /*打开通道*/
        channel = ServerSocketChannel.open();
        /*非阻塞模式*/
        channel.configureBlocking(false);
        /*本机IP*/
        //InetAddress ip = InetAddress.getByName("127.0.0.1");
        InetAddress ip = InetAddress.getLocalHost();
        System.out.println("绑定的本机IP和端口: " + ip.toString() + ":" + port);
        /*绑定IP和端口*/
        InetSocketAddress address = new InetSocketAddress(ip,port);
        socket = channel.socket();
        socket.bind(address);
        /*启动监听*/
        System.out.println("TCP服务器开始监听...");
        Listen();
    }

    /*停止*/
    public void Stop() throws Exception {
        channel.close();
        selector.close();
    }

    /*监听*/
    public void Listen() throws Exception {
        /*注册接收事件*/
        channel.register(selector,SelectionKey.OP_ACCEPT);
        /*无限循环*/
        while (true) {
            selector.select();
            /*轮询事件*/
            Iterator iter = selector.selectedKeys().iterator();
            while (iter.hasNext()) {
                SelectionKey key =  (SelectionKey)iter.next();
                iter.remove();
                /*事件分类处理*/
                if (key.isAcceptable()) {
                    ServerSocketChannel ssc = (ServerSocketChannel)key.channel();
                    SocketChannel sc = ssc.accept();
                    sc.configureBlocking(false);
                    sc.register(selector, SelectionKey.OP_READ);
                    System.out.println("--->" + sc.getRemoteAddress() + "  new client connected");
                }
                else if (key.isReadable()) {
                    buffer.flip();
                    SocketChannel sc = (SocketChannel)key.channel();
                        int recvCount = sc.read(buffer);
                    if (recvCount > 0) {
                        byte[] arr = buffer.array();
                        String receiveData = new String(arr);
                        if (!StringUtils.isEmpty(receiveData)) {
                            RobotGaitEntity entity = this.robotGaitEntityToObj(receiveData);

                        }
                        System.out.println("--->" + sc.getRemoteAddress() + "  send data: "+ receiveData);
                        sc.write(ByteBuffer.wrap("hahahah".getBytes()));
                    }
                    else {
                        System.out.println("--->" + sc.getRemoteAddress() + "  client disconnected");
                        buffer.clear();
//                        buffer.flip();
                        sc.close();
                    }
                    buffer.clear();
                }
                else {

                }
            }
        }
    }

    /**
     * 数据封装
     * @return
     */
    public RobotGaitEntity robotGaitEntityToObj(String str) {
        RobotGaitEntity gaitEntity = new RobotGaitEntity();
        RobotGaitEntity data = (RobotGaitEntity) JSON.parse(str);
        gaitEntity.setStepAmplitude(data.getStepAmplitude());
        gaitEntity.setStepWidth(data.getStepWidth());
        gaitEntity.setStepFrequency(data.getStepFrequency());
        gaitEntity.setStepLength(data.getStepLength());
        gaitEntity.setLeftHipAngle(data.getLeftHipAngle());
        gaitEntity.setLeftKneeAngle(data.getLeftKneeAngle());
        gaitEntity.setLeftToePressure(data.getLeftToePressure());
        gaitEntity.setLeftHeelPressure(data.getLeftHeelPressure());
        gaitEntity.setRightHipAngle(data.getRightHipAngle());
        gaitEntity.setRightKneeAngle(data.getRightKneeAngle());
        gaitEntity.setRightToePressure(data.getRightToePressure());
        gaitEntity.setRightHeelPressure(data.getRightHeelPressure());
        return gaitEntity;
    }


}