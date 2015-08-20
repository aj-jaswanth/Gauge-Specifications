import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SearchImplementation {
    
    @Step("Navigate to <localhost:3000/>")
    public void visitWebPage(String url) {
        DriverFactory.driver.get(url);
    }

    @Step("Enter <bag> in the search box")
    public void fillSearchBox(String productName) {
        WebElement searchBox = DriverFactory.driver.findElement(By.id("keywords"));
        searchBox.sendKeys(productName);
    }

    @Step("Click the search button")
    public void submitSearch() {
        WebElement searchBox = DriverFactory.driver.findElement(By.id("keywords"));
        searchBox.submit();
    }

    @Step("Ensure result contains the following products <table>")
    public void assertSearchResults(Table products) {
        List<List<String>> prodcutRows = products.getRows();
        String firstProdcut = prodcutRows.get(0).get(0);
        String secondProduct = prodcutRows.get(1).get(0);

        WebElement firstElement = DriverFactory.driver.findElement(By.xpath("//*[@id='product_2']/a"));
        WebElement secondElement = DriverFactory.driver.findElement(By.xpath("//*[@id='product_12']/a"));

        assertEquals(firstElement.getText(), firstProdcut);
        assertEquals(secondElement.getText(), secondProduct);
    }
}
