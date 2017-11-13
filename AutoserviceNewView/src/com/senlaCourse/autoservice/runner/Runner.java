package com.senlaCourse.autoservice.runner;

import com.senlaCourse.autoservice.server.MyServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner {
    static ExecutorService executeIt = Executors.newFixedThreadPool(2);
    public static void main(String[] args) {
        Integer port = 8181;
        try (ServerSocket serverSocket = new ServerSocket(port);
             ) {
            System.out.println("Server socket created, command console reader for listen to server commands");
            Socket socket = serverSocket.accept(); // заставляем сервер ждать подключений и выводим сообщение когда кто-то связался с сервером
            System.out.println("Got a client :) ... Finally, someone saw me through all the cover!");
            System.out.println();
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            while(true) {
                String line = in.readUTF(); // ожидаем пока клиент пришлет строку текста.
                System.out.println("The dumb client just sent me this line : " + line);
                System.out.println("I'm sending it back...");
                out.writeUTF(line); // отсылаем клиенту обратно ту самую строку текста.
                out.flush(); // заставляем поток закончить передачу данных.
                System.out.println("Waiting for the next line...");
                System.out.println();
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}





