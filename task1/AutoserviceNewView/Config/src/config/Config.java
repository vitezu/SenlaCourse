package config;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.Properties;

public class Config {
    private static Config instance = null;

    protected Config() {
    }

    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }

    private Logger logger = Logger.getLogger(Config.class);
    private Properties props;

    public Properties getProperty() {
        return this.props;
    }

    public void loadProperties() {

        File configFile = new File("Config\\resources\\config.properties");

        try {
            FileReader reader = new FileReader(configFile);
            props = new Properties();
            props.load(reader);
            reader.close();
        } catch (FileNotFoundException ex) {
            logger.error("File does not exist");
        } catch (IOException ex) {
            logger.error("IO error");
        }
    }
}