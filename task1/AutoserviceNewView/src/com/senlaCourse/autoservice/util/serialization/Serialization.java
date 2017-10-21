package com.senlaCourse.autoservice.util.serialization;

import com.senlaCourse.autoservice.controller.ControllerImpl;
import com.senlaCourse.autoservice.util.Printer;
import config.Config;
import org.apache.log4j.Logger;

import java.io.*;

public class Serialization {
    private Logger logger = Logger.getLogger(ControllerImpl.class);
    private Printer printer;

    public void serialize(Object object, String key) {
        String path = Config.getInstance().getStringProperties(key);
        try (FileOutputStream fileOut = new FileOutputStream(path); ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(object);
        } catch (IOException i) {
            logger.error("IO error");
        }
    }

    public Object deserialize(String key) {
        String path = Config.getInstance().getStringProperties(key);
        Object object = null;
        try (FileInputStream fileIn = new FileInputStream(path); ObjectInputStream in = new ObjectInputStream(fileIn)) {
            object = in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            logger.error("IO error");
        } catch (ClassNotFoundException c) {
            logger.error("Master class not found");
        }
               return object;
    }
}
