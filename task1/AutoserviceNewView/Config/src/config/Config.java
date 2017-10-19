package config;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.Properties;

public class Config {
    private Logger logger = Logger.getLogger(Config.class);
    private Properties props;
    private FileReader reader;

    private static Config instance = null;

    public Config() {
        loadProperties();
    }

    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }

    public void loadProperties() {

        File configFile = new File("Config\\resources\\config.properties");
        try {
            reader = new FileReader(configFile);
            props = new Properties();
            props.load(reader);
        } catch (FileNotFoundException ex) {
            logger.error("File does not exist");
        } catch (IOException ex) {
            logger.error("IO error");
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                logger.error("IO error");
            }
        }
    }

    public Boolean getBoolProperties(String key) {
        return Boolean.valueOf(props.getProperty(key));
    }
}