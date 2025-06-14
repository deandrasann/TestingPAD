import org.example.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginNegativeTest {
    private WebDriver driver;
    private LoginPage login;

    @BeforeTest
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("http://127.0.0.1:8000/login");
    }

    @Test
    public void loginWithInvalidPassword(){
        login = new LoginPage(driver);
        login.fillUsername("john_doe");
        login.fillPassword("John123");
        login.clickLogin();

        // Validasi: pesan error muncul
        Assert.assertEquals(login.getErrorMessageText(), "Login gagal", "Pesan error tidak sesuai");
    }
}
