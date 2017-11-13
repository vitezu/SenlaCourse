package com.senlaCourse.autoservice.server;

import com.senlaCourse.autoservice.api.controller.IController;
import com.senlaCourse.autoservice.dependancy.DependancyInjection;
import com.senlaCourse.commonData.Request;
import com.senlaCourse.commonData.Response;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.Socket;

public class ServerThread extends Thread {
    protected Socket socket;
    private static Logger logger = Logger.getLogger(ServerThread.class);
    private IController controller = (IController) DependancyInjection.getInstance().load(IController.class);

    public ServerThread(Socket clientSocket) {
        this.socket = clientSocket;
    }

    public void run() {
        try {
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            while (true) {
                String nameMethod;
                Object[] parameters;

                Request request = (Request) in.readObject();
                nameMethod = request.getNameMethod();
                parameters = request.getParameters();

                Object object = controller.getClass().getMethod(nameMethod, Object.class).invoke(controller, parameters);
                Response response = new Response();
                response.setResult(object);
                response.setSuccess(true);
                out.writeObject(response);

                in.close();
                out.close();
            }
        } catch (IOException e) {
            logger.error("IO error");
        } catch (ClassNotFoundException e) {
            logger.error("Class is not found");
        } catch (NoSuchMethodException e) {
            logger.error("Method is not such");
        } catch (IllegalAccessException e) {
            logger.error("Have not access ");
        } catch (InvocationTargetException e) {
            logger.error("Invocation target");
        }
    }
}
