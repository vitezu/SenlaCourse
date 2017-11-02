package com.senlaCourse.annotation.property;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyManager {
    private Logger logger = Logger.getLogger(PropertyManager.class);
    private Map<String, String> propsMap = new HashMap<>();
    private Properties props;

    public String getProps(String path, String key) {

        if (propsMap.containsKey(key)) {
            return propsMap.get(key);
        } else {
            File configFile = new File(path);
            try (FileInputStream fis = new FileInputStream(configFile)) {
                props = new Properties();
                props.load(fis);
                propsMap.put(key,props.getProperty(key));
            } catch (IOException e) {
                logger.error("Can not read file", e);
            }
        }
       return propsMap.get(key);
    }
}

