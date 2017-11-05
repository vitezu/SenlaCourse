package com.senlaCourse.autoservice.dependancy;

import com.senlaCourse.annotation.property.PropertyManager;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;


public class DependancyInjection {
    private final static String CONFIG_NAME = "resources\\configDI.properties";
    private Logger logger = Logger.getLogger(DependancyInjection.class);
    private PropertyManager propertyManager = new PropertyManager();
    private static DependancyInjection instance = null;
    private Map<Class<?>, Object> mapDi = new HashMap<Class<?>, Object>();

    public DependancyInjection() {
    }

    public static DependancyInjection getInstance() {
        if (instance == null) {
            instance = new DependancyInjection();
        }
        return instance;
    }

    public Object load(Class<?> interf) {
        if (mapDi.containsKey(interf)) {
            return mapDi.get(interf);
        } else {
            try {
                String value;
                Class clazz = Class.forName(interf.getName());
                String nameInterf = clazz.getName();
                value = propertyManager.getProps(CONFIG_NAME, nameInterf);
                Object result = Class.forName(value).newInstance();
                mapDi.put(interf, result);
            } catch (ReflectiveOperationException e) {
                logger.error("Couldn't find an implementation", e);
            }
        }
        return mapDi.get(interf);
    }
}
