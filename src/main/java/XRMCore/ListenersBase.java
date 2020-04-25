package XRMCore;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.cucumber.core.exception.CucumberException;
import io.cucumber.core.internal.gherkin.ast.Feature;
import io.cucumber.core.internal.gherkin.events.CucumberEvent;
import io.cucumber.testng.CucumberOptions;
import org.apache.log4j.Logger;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class ListenersBase implements ITestListener {

    private static Logger logger = Logger.getLogger(ListenersBase.class.getName());

    ExtentHtmlReporter htmlReporter;
    ExtentReports extentReports;
    ExtentTest extentTest;

    public ListenersBase() {
        htmlReporter = new ExtentHtmlReporter(BuildLocation.getBuildLocation() + "/src/reports/report.html");
    }

    @Override
    public void onTestStart(ITestResult result) {

        logger.info("Test execution stared");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest = extentReports.createTest(result.getName());
        logger.info(result.getName() + " Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.info(result.getName() + " Failed");
        try {
            TakeScreenshot.takeScreenshot(result.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        extentTest = extentReports.createTest(result.getName());
        try {
            extentTest.log(Status.FAIL, result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(TakeScreenshot.getScreenshot(result.getName())).build());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {
        htmlReporter.config().setDocumentTitle(context.toString());
        htmlReporter.config().setReportName(Feature.class.getName());
        htmlReporter.config().setTheme(Theme.DARK);

        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
        extentReports.setSystemInfo("HostName", "LocalHost");
        try {
            extentReports.setSystemInfo("Browser", PropertyReader.getProperty("Browser"));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
        logger.info("Test Execution finished " + context.getName());
    }
}
