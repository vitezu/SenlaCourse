package com.senlaCourse.annotation.config;

import org.apache.log4j.Logger;
import com.senlaCourse.annotation.util.UtilConvertString;
import com.senlaCourse.annotation.property.PropertyManager;

import java.lang.reflect.Field;

public class AutoConfigurationProgramm {

    private UtilConvertString util = new UtilConvertString();

    private Logger logger = Logger.getLogger(AutoConfigurationProgramm.class);

    private static AutoConfigurationProgramm instance = null;

    public static AutoConfigurationProgramm getInstance() {
        if (instance == null) {
            instance = new AutoConfigurationProgramm();
        }
        return instance;
    }

    public void configureObject(Object object) {

        try {
            Class<?> clazz = object.getClass();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {

                ConfigProperty configProperty = field.getAnnotation(ConfigProperty.class);
                if (configProperty != null) {
                    PropertyManager propertyManager = new PropertyManager();
                    String configName;
                    String propertyName;
                    Class<?> type;
                    Boolean isAccess = field.isAccessible();
                    field.setAccessible(true);

                    configName = configProperty.configName();
                    propertyName = configProperty.propertyName();
                    type = configProperty.type();
                    String value = propertyManager.getProps(configName, propertyName);
                    Object o = util.convert(value, type);
                    field.set(object, o);
                    field.setAccessible(isAccess);
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
