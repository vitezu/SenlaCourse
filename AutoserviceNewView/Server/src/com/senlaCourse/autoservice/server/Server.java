package com.senlaCourse.autoservice.server;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    static final int PORT = 8181;
    private static Logger logger = Logger.getLogger(Server.class);

    public static void main(String args[]) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            logger.error("I/O error: ", e);

        }
        while (true) {
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                logger.error("I/O error: ", e);
            }
            new ServerThread(socket).start();
        }
    }
}
