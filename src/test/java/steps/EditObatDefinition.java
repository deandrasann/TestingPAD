package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DashboardPage;
import pages.ObatPage;
import pages.ResultPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EditObatDefinition {
    WebDriver driver;
    ResultPage result;
    LoginStepHelper loginHelper;
    DashboardPage dashboard;
    ObatPage obat;


    public EditObatDefinition() {
        this.driver = Hooks.driver; // ambil driver dari Hooks
        this.result = new ResultPage(driver);
        this.loginHelper = new LoginStepHelper(driver);
        this.dashboard = new DashboardPage(driver);
        this.obat = new ObatPage(driver);
    }
    @When("apoteker mengeklik tombol edit pada obat")
    public void apoteker_mengeklik_tombol_edit_pada_obat() {
        obat.showEditModal();

    }
    @When("apoteker mengubah field yang diinginkan")
    public void apoteker_mengubah_field_yang_diinginkan() {
        obat.hapusKekuatanSediaan();
        obat.isiKekuatanSediaan("1");
    }
    @When("apoteker menekan tombol simpan pada modal edit")
    public void apoteker_menekan_tombol_simpan_pada_modal_edit() {
        obat.simpanEdit();
    }
    @Then("data obat berhasil diperbarui")
    public void data_obat_berhasil_diperbarui() {
        result.showEditMsg();
        Assertions.assertTrue(result.showEditMsg());

    }

    @And("apoteker mengkosongkan salah satu field saat edit")
    public void apotekerMengkosongkanSalahSatuFieldSaatEdit() {
        obat.hapusKekuatanSediaan();
        obat.isiKekuatanSediaan("");
    }

    @And("apoteker menginputkan kekuatan sediaan dengan tipe data string saat edit")
    public void apotekerMenginputkanKekuatanSediaanDenganTipeDataStringSaatEdit() {
        obat.hapusKekuatanSediaan();
        obat.isiKekuatanSediaan("9mg");
    }
}