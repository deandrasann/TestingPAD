package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.ObatPage;
import pages.PasienPage;
import pages.ResultPage;

public class LihatPasienDefinition {
    WebDriver driver;
    ResultPage result;
    DashboardPage dashboardPage;

    public LihatPasienDefinition() {
        this.driver = Hooks.driver;
        this.dashboardPage = new DashboardPage(driver);
        this.result = new ResultPage(driver);
    }
    @When("apoteker mengeklik tombol pasien di sidebar")
    public void apoteker_mengeklik_tombol_pasien_di_sidebar() {
        dashboardPage.showPasienPage();

    }
    @Then("tampil data pasien")
    public void tampil_data_pasien() {
        result.dataPasienDisplayed();
    }
}
