import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static junit.framework.Assert.assertEquals;

public class CheckLogin {

    @Step("Open URL <http://127.0.0.1:3000/login>")
    public void visitWebPage(String url) {
        DriverFactory.driver.get(url);
    }

    @Step("Enter username <j@j.com>")
    public void enterUserName(String userName) {
        WebElement userNameField = DriverFactory.driver.findElement(By.id("spree_user_email"));
        userNameField.sendKeys(userName);
    }

    @Step("Enter password <abcdefgh>")
    public void enterPassword(String password) {
        WebElement passwordField = DriverFactory.driver.findElement(By.id("spree_user_password"));
        passwordField.sendKeys(password);
    }

    @Step("Click submit")
    public void submit() {
        WebElement submitButton = DriverFactory.driver.findElement(By.name("commit"));
        submitButton.click();
    }

    @Step("Verify text <LOGOUT>")
    public void verifyLogoutIsDisplayed(String stringToBeDisplayed) {
        WebElement logoutElement = DriverFactory.driver.findElement(By.linkText("LOGOUT"));
        assertEquals(stringToBeDisplayed, logoutElement.getText());
    }
}
