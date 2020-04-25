package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy(xpath = "//span[text()='Login']")
    WebElement loginLink;

    public WebElement getLoginLink() {
        return loginLink;
    }
}
