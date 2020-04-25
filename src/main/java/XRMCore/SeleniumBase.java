package XRMCore;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SeleniumBase {

    public static WebDriver driver;
    private static Logger logger = Logger.getLogger(SeleniumBase.class.getName());

    public static WebDriver InitializeDriver() throws IOException {

        String browser = PropertyReader.getProperty("Browser");
        logger.info("Browser invoked is : " + browser);

        switch (browser) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setAcceptInsecureCerts(true);

                System.setProperty("webdriver.chrome.driver", BuildLocation.getBuildLocation() + "/src/main/resources/chromedriver");
                driver = new ChromeDriver(chromeOptions);
                break;
            default:
                System.out.println("Given browser value : " + browser + " is not handled");
                break;
        }

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public void QuitBrowser() {
        this.driver.close();
        this.driver.quit();
        this.driver = null;
    }

}
