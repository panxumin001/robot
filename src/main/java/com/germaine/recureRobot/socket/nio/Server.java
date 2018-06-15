package com.germaine.recureRobot.socket.nio;

public class Server {
    public static void main(String[] args) throws Exception {

        TcpAsyncServer tcpServer = new TcpAsyncServer();
        tcpServer.Start();

    }

}
