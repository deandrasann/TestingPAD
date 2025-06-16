package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.ResultPage;
import org.junit.jupiter.api.Assertions;
import utils.DriverFactory;

import java.time.Duration;

public class LoginStepDefinitions {
    private WebDriver driver;
    private LoginPage loginPage;
    private ResultPage resultPage;

    @Given("Pengguna berada di halaman login")
    public void pengguna_berada_di_halaman_login() {
        driver = DriverFactory.initDriver();
        driver.get("http://127.0.0.1:8000/login");
        loginPage = new LoginPage(driver);
    }

    @When("Pengguna memasukkan username {string} dan password {string}")
    public void pengguna_memasukkan_username_dan_password(String username, String password) {
        loginPage.fillUsername(username);
        loginPage.fillPassword(password);
    }

    @When("Pengguna menekan tombol Login")
    public void pengguna_menekan_tombol_login() {
        loginPage.clickLogin();
    }

    @Then("Pengguna diarahkan ke halaman dashboard apoteker")
    public void pengguna_diarahkan_ke_halaman_dashboard_apoteker() {
        resultPage = new ResultPage(driver);
        Assertions.assertTrue(resultPage.BerandaDisplayed());
    }

    @Then("Muncul pesan error login")
    public void muncul_pesan_error_login() {
        // Ganti dengan locator yang spesifik untuk pesan error
        By errorMessage = By.cssSelector(".alert.alert-danger");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
            Assertions.assertTrue(errorElement.isDisplayed());
        } catch (TimeoutException e) {
            Assertions.fail("Pesan error tidak muncul");
        }
    }
}
