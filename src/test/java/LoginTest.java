import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ResultPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import utils.DriverFactory;

public class LoginTest {
    private WebDriver driver;
    private LoginPage login;
    private ResultPage result;

    @BeforeTest
    public void setUpObject() {
        driver = DriverFactory.initDriver();
        driver.get("http://127.0.0.1:8000/login");
    }

    @Test
    public void testLoginSuccess() {
        login = new LoginPage(driver);
        result = new ResultPage(driver);

        login.fillUsername("apoteker1");
        login.fillPassword("apoteker123");
        login.clickLogin();

        assertTrue(result.BerandaDisplayed());
    }
}