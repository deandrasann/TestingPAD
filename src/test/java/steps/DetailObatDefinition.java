package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.DashboardPage;
import pages.ObatPage;
import pages.ResultPage;

public class DetailObatDefinition {

    WebDriver driver;
    ResultPage result;
    ObatPage obat;
    LoginStepHelper loginHelper;

    public DetailObatDefinition() {
        this.driver = Hooks.driver;
        this.obat = new ObatPage(driver);
        this.result = new ResultPage(driver);
    }

    @When("apoteker mencari nama obat yang baru ditambahkan")
    public void apoteker_mencari_nama_obat_yang_baru_ditambahkan() {
        obat = new ObatPage(driver);
        obat.searchObat("Paracetamol");
    }
    @And("apoteker menekan tombol detail obat")
    public void apoteker_menekan_tombol_detail_obat() {
        obat.showDetail();
    }
    @Then("tampil modal detail obat dengan informasi lengkap")
    public void tampil_modal_detail_obat_dengan_informasi_lengkap() {
        result = new ResultPage(driver);
    }
}
