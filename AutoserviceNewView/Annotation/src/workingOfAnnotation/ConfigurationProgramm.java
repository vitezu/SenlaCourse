package workingOfAnnotation;

import org.apache.log4j.Logger;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ConfigurationProgramm {

    public static String path1;
    public static String path2;
    public static Class path3;

    private static ConfigurationProgramm instance = null;

    public static ConfigurationProgramm getInstance() {
        if (instance == null) {
            instance = new ConfigurationProgramm();
        }
        return instance;
    }

    private Logger logger = Logger.getLogger(ConfigurationProgramm.class);

    public void getParameters(String nameClass) {

        ConfigProperty configProperty = null;
        try {
            Class<?> clazz = Class.forName(nameClass);

            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                configProperty = method.getAnnotation(ConfigProperty.class);
                if (configProperty != null) {
                    path1 = configProperty.configName();
                    path2 = configProperty.propertyName();
                    path3 = configProperty.type();
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void setInjection(String nameClass) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> clazz = Class.forName(nameClass);
        Object object1 = clazz.newInstance();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            Annotation annotation = field.getAnnotation(Inject.class);
            if (annotation != null) {
                field.setAccessible(true);
                Class<?> type = field.getType();
                Object object2 = type.newInstance();
                field.set(object1, object2);
                field.setAccessible(false);
            }
        }
        System.out.println(object1);
    }
}
