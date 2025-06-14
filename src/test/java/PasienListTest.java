
import org.example.DashboardPage;
import org.example.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class PasienListTest {
    WebDriver driver;
    LoginPage login;
    DashboardPage dashboard;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://127.0.0.1:8000/login");

        login = new LoginPage(driver);
        login.fillUsername("apoteker1"); // Sesuaikan dengan username valid
        login.fillPassword("apoteker123"); // Sesuaikan dengan password valid
        login.clickLogin();
    }

    @Test
    public void pasienListShouldBeVisible() {
        dashboard = new DashboardPage(driver);
        dashboard.clickPasienSidebar();

        Assert.assertTrue(dashboard.isOnPasienPage(), "Gagal masuk ke halaman pasien");
        Assert.assertTrue(dashboard.isListPasienVisible(), "Data pasien tidak ditemukan");
    }
}

