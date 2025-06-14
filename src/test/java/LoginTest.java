import org.example.LoginPage;
import org.example.ResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {
    private WebDriver driver;
    private LoginPage login;
    private ResultPage result;

    @BeforeTest
    public void setUpObject(){
        driver = new ChromeDriver();
        driver.get("http://127.0.0.1:8000/login");
    }
    @Test
    public void login(){
        login = new LoginPage(driver);
        result = new ResultPage(driver);
        login.fillUsername("apoteker1");
        login.fillPassword("apoteker123");
        login.clickLogin();

    }

    public String getErrorMessage() {
        return driver.findElement(By.id("loginError")).getText(); // ID dengan HTML login
    }


}
