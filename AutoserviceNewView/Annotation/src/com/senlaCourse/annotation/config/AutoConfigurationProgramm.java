package com.senlaCourse.annotation.config;

import org.apache.log4j.Logger;
import com.senlaCourse.annotation.util.UtilConvertString;
import com.senlaCourse.annotation.property.PropertyManager;

import java.lang.reflect.Field;

public class AutoConfigurationProgramm {
    private String configName;
    private String propertyName;
    private Class<?> type;
    private UtilConvertString util;

    private Logger logger = Logger.getLogger(AutoConfigurationProgramm.class);
    private PropertyManager propertyManager = new PropertyManager();

    private static AutoConfigurationProgramm instance = null;

    public static AutoConfigurationProgramm getInstance() {
        if (instance == null) {
            instance = new AutoConfigurationProgramm();
        }
        return instance;
    }

    public Object configureObject(String cl)  {
        Object object = null;
        ConfigProperty configProperty;
        try {
            Class<?> clazz = Class.forName(cl);
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                configProperty = field.getAnnotation(ConfigProperty.class);
                System.out.println(configProperty);
                if (configProperty != null) {
                    field.setAccessible(true);
                    configName = configProperty.configName();
                    propertyName = configProperty.propertyName();
                    type = configProperty.type();
                    String value = propertyManager.getProps(configName, propertyName);
                    object = util.convert(value, type);
                }
            }
        } catch (ClassNotFoundException e) {
            logger.error("Class not found", e);
        }
        return object;
    }
}
