package stepDefinitions;

import XRMCore.PropertyReader;
import XRMCore.SeleniumBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import pageObjects.HomePage;
import pageObjects.Login;

public class LoginStepDefinitions extends SeleniumBase {

    @Given("^Initialize Login$")
    public void initialize_login() throws Throwable {
        InitializeDriver();
        getDriver().get(PropertyReader.getProperty("URL"));
    }

    @When("^I click on login link$")
    public void i_click_on_login_link() throws Throwable {
        HomePage homePage = PageFactory.initElements(getDriver(), HomePage.class);
        homePage.getLoginLink().click();
    }

    @Then("^Click on login button$")
    public void click_on_login_button() throws Throwable {
        Login login = PageFactory.initElements(getDriver(), Login.class);
        login.getLoginButton().click();
    }

    @And("^I Enter (.+) and (.+)$")
    public void i_enter_and(String username, String password) throws Throwable {
        Login login = PageFactory.initElements(getDriver(), Login.class);
        login.getUserName().clear();
        login.getUserName().sendKeys(username);
        login.getPassword().clear();
        login.getPassword().sendKeys(password);
    }

    @Then("^I Close the browser$")
    public void i_close_the_browser() throws Throwable {
        QuitBrowser();
    }

}
