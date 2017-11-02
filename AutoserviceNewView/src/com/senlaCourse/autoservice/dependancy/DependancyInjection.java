package com.senlaCourse.autoservice.dependancy;

import com.senlaCourse.annotation.property.PropertyManager;
import org.apache.log4j.Logger;

public class DependancyInjection {
    private final static String CONFIG_NAME = "resources\\configDI.properties";
    private Logger logger = Logger.getLogger(DependancyInjection.class);
    private PropertyManager propertyManager = new PropertyManager();
    private static DependancyInjection instance = null;

    public DependancyInjection() {
    }

    public static DependancyInjection getInstance() {
        if (instance == null) {
            instance = new DependancyInjection();
        }
        return instance;
    }
    private String value;

    public Object load(Class<?> interf) {
        try {
            Class clazz = Class.forName(interf.getName());
            String nameInterf = clazz.getName();
            value = propertyManager.getProps(CONFIG_NAME, nameInterf);
            return Class.forName(value).newInstance();
        } catch (ReflectiveOperationException e) {
            logger.error("Couldn't find an implementation", e);
            return null;
        }
    }
}
