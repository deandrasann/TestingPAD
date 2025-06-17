package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.PasienPage;
import pages.ResultPage;

public class LogOutDefinition {
    WebDriver driver;
    ResultPage result;
    PasienPage pasienPage;
    DashboardPage dashboardPage;
    LoginStepHelper loginHelper;

    public LogOutDefinition() {
        this.driver = Hooks.driver;
        this.dashboardPage = new DashboardPage(driver);
        this.pasienPage = new PasienPage(driver);
        this.result = new ResultPage(driver);
        this.loginHelper = new LoginStepHelper(driver);
    }
    @Given("apoteker berada di halaman pasien")
    public void apoteker_berada_di_halaman_pasien() {
        loginHelper.loginAsApoteker();
        dashboardPage.showPasienPage();
    }
    @When("Apoteker menekan tombol log out")
    public void apoteker_menekan_tombol_log_out() {
        pasienPage.clickLogOut();
    }
    @Then("Apoteker berada di halaman login")
    public void apoteker_berada_di_halaman_login() {
        Assertions.assertEquals("http://127.0.0.1:8000/login", driver.getCurrentUrl());
    }
}
