package steps;

import org.example.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginStepHelper {
    private WebDriver driver;

    public LoginStepHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void loginAsApoteker() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUsername("apoteker1");
        loginPage.fillPassword("apoteker123");
        loginPage.clickLogin();
    }
}
