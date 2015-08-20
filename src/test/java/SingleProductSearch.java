import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class SingleProductSearch {
    @Step("Enter <bag> in the search field")
    public void fillInSearchBox(String productName) {
        WebElement searchBoxField = DriverFactory.driver.findElement(By.id("keywords"));
        searchBoxField.sendKeys(productName);
        searchBoxField.submit();
    }

    @Step("Open URL <http://localhost:3000/login>")
    public void openURL(String url) {
        DriverFactory.driver.get(url);
    }

    @Step("Verify element <Ruby on Rails Bag> is present in the results")
    public void verifyResult(String productName) {
        WebElement railsElement = DriverFactory.driver.findElement(By.xpath("//*[@id='product_2']/a"));
        String result = railsElement.getText();

        assertEquals(productName, result);
    }
}
