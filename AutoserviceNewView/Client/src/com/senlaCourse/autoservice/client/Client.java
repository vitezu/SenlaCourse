package com.senlaCourse.autoservice.client;

import com.senlaCourse.commonData.Request;
import com.senlaCourse.commonData.Response;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    private Logger logger = Logger.getLogger(Client.class);
    public static void main(String[] args) {

    }

    public Object sendRequest(Request request) {
        Response response = null;
        try (Socket socket = new Socket("localhost", 8181);
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream input = new ObjectInputStream(socket.getInputStream())) {
            while (!socket.isOutputShutdown()) {
                out.writeObject(request);
                response = (Response) input.readObject();
            }
        } catch (IOException e) {
            logger.error("IO error");
        } catch (ClassNotFoundException e) {
            logger.error("Class is not found");        }
        return response;
    }
}
