package com.senlaCourse.autoservice.serialization;

import com.senlaCourse.autoservice.controller.ControllerImpl;
import com.senlaCourse.autoservice.entity.Master;
import com.senlaCourse.autoservice.util.Printer;
import config.Config;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.Properties;

public class Serialization {
    private Logger logger = Logger.getLogger(ControllerImpl.class);
    private Properties props;
    private Printer printer;

    public void serialize(Master master) {
        Config.getInstance().loadProperties();
        props = Config.getInstance().getProperty();

        try {
            FileOutputStream fileOut = new FileOutputStream(props.getProperty("pathSerial"));
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(master);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in pathSerial");
        } catch (IOException i) {
            logger.error("IO error");
        }
    }

    public void deserialize() {
        Master master = null;
        try {
            FileInputStream fileIn = new FileInputStream(props.getProperty("pathSerial"));
            ObjectInputStream in = new ObjectInputStream(fileIn);
            master = (Master) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            logger.error("IO error");
        } catch (ClassNotFoundException c) {
            System.out.println("Master class not found");
            c.printStackTrace();
        }
        System.out.println(master);
    }
}
