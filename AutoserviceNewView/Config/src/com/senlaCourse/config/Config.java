package com.senlaCourse.config;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Config  {
    private Logger logger = Logger.getLogger(Config.class);
    private Properties props;
    private Map<String, Object> propsMap = new HashMap<>();

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
        try (FileReader reader = new FileReader(configFile)) {
            props = new Properties();
            props.load(reader);
        } catch (FileNotFoundException e) {
            logger.error("File does not exist", e );
        } catch (IOException ex) {
            logger.error("Can  not read file", ex);
        }
    }

    public Boolean getBoolProperties(String key) {
        return Boolean.valueOf(props.getProperty(key));
    }

    public String getStringProperties(String key) {
        return props.getProperty(key);
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Config{");
        sb.append("props=").append(props);
        sb.append('}');
        return sb.toString();
    }
}