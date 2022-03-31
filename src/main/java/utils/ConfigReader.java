package utils;
import java.io.*;
import java.util.Properties;

public  class ConfigReader {
    private static Properties properties;


    public static String getProperty(String propKey){
        String value="";
        FileInputStream fis = null;
        try {
            properties = new Properties();
            fis = new FileInputStream("config.properties");
            properties.load(fis);

        } catch (Exception e) {
            e.printStackTrace();
        }


         value = properties.getProperty(propKey);
        return value;
    }
}
