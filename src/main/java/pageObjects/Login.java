package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {

    @FindBy(id = "user_email")
    WebElement userName;

    @FindBy(id = "user_password")
    WebElement password;

    @FindBy(xpath = "//input[@name='commit']")
    WebElement loginButton;

    public WebElement getUserName() {
        return userName;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }
}
