package workingOfAnnotation;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Config {
    private static final String FILE = "Config\\resources\\config.properties";
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

        File configFile = new File(FILE);
        try (FileReader reader = new FileReader(configFile)) {
            props = new Properties();
            props.load(reader);
        } catch (FileNotFoundException ex) {
            logger.error("File does not exist");
        } catch (IOException ex) {
            logger.error("IO error");
        }
    }

    public Object getProps(String path) {
        if (propsMap.containsKey(path)) {
            return propsMap.get(path);
        } else {
            propsMap.put(path, props.getProperty(path));
        }
        return propsMap.get(path);
    }
    public Boolean getBoolProperties(String key) {
        return Boolean.valueOf(props.getProperty(key));
    }

    public String getStringProperties(String key) {
        return props.getProperty(key);
    }
}