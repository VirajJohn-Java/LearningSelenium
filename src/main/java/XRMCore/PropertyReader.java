package XRMCore;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    private static Logger logger = Logger.getLogger(PropertyReader.class.getName());

    public static String getProperty(String property) throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(
                new File(BuildLocation.getBuildLocation() + "/src/main/resources/Properties.properties"));
        properties.load(fileInputStream);
        logger.info(property + " : Property read from property file");
        return properties.getProperty(property);
    }
}
