package core;

import org.apache.log4j.PropertyConfigurator;
import org.testng.Reporter;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * Created by CTAJlb on 03.10.2016.
 */
public class PropertyConfig {

    private static Properties properties;

    private static void loadProperties() {
        properties = new Properties();
        FileInputStream propFile;
        try {

            propFile = new FileInputStream(System.getProperty("user.dir") +  "//src//main//resources//test.properties");
            PropertyConfigurator.configure(System.getProperty("user.dir") + "//src//main//resources//log4j.properties");
            properties.load(propFile);
        } catch (Exception e) {
            Reporter.log("Unable to read resource file", true);
            Reporter.log(e.getMessage(), true);
        }
    }

    public static String getProperty(String propertyName) {

        if (properties == null) {
            loadProperties();
        }
        return properties.getProperty(propertyName);
    }
}
