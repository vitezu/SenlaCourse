package config;

public interface IConfig {

    public void loadProperties();
    public Object getProps(String path);
}
