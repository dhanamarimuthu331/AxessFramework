package Readers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties prop = new Properties();

    static
    {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/PropertyFile/env.properties");
            prop.load(fis);
        } catch (IOException e) {
            System.out.println("File Not Found");
        }


    }public static String getProp(String key)
    {
        return prop.getProperty(key);
    }

}
