import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeSuite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public static WebDriver driver;

    @BeforeSuite
    public void setUp() {
        driver = new FirefoxDriver();
    }

    @AfterSuite
    public void tearDown() {
        driver.close();
    }
}
