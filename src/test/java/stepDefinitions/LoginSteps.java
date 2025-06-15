package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.DriverFactory;
import io.cucumber.java.en.*;
import static org.junit.Assert.*;

public class LoginSteps {
    WebDriver driver;
    LoginPage loginPage;

    @Given("Pengguna berada di halaman login")
    public void halaman_login() {
        driver = DriverFactory.initDriver();
        driver.get("http://127.0.0.1:8000/login"); // URL lokal
        loginPage = new LoginPage(driver);
    }

    @When("Pengguna memasukkan username {string} dan password {string}")
    public void input_akun(String user, String pass) {
        loginPage.enterUsername(user);
        loginPage.enterPassword(pass);
    }

    @And("Pengguna menekan tombol Login")
    public void tekan_login() {
        loginPage.clickLogin();
    }

    @Then("Pengguna diarahkan ke halaman dashboard apoteker")
    public void ke_dashboard() {
        // Misal dashboard ada di URL ini
        assertTrue(driver.getCurrentUrl().contains("/dashboard") ||
                driver.getPageSource().toLowerCase().contains("apoteker"));
    }

    @Then("Muncul pesan error login")
    public void muncul_pesan_error_login() {
        boolean isErrorDisplayed = driver.findElement(By.id("loginError")).isDisplayed();
        assertTrue("Pesan error login tidak muncul", isErrorDisplayed);
    }
}
