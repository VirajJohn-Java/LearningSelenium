package XRMCore;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;


public class TakeScreenshot extends SeleniumBase {

    private static Logger logger = Logger.getLogger(TakesScreenshot.class.getName());

    public static void takeScreenshot(String fileName) throws IOException {
        logger.info("Took Screenshot : " + fileName +".png");
        File pic = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(pic, new File(BuildLocation.getBuildLocation()+ "/src/screenshots/"+ fileName + ".png"));
    }

    public static String getScreenshot(String fileName)
    {
        return BuildLocation.getBuildLocation()+ "/src/screenshots/"+ fileName + ".png";
    }
}
