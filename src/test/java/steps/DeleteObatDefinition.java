package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.ObatPage;
import pages.ResultPage;

public class DeleteObatDefinition {
    WebDriver driver;
    ResultPage result;
    ObatPage obat;
    public DeleteObatDefinition() {
        this.driver = Hooks.driver;
        this.obat = new ObatPage(driver);
        this.result = new ResultPage(driver);
    }
    @When("apoteker mencari nama obat yang akan dihapus")
    public void apoteker_mencari_nama_obat_yang_akan_dihapus() {
        obat.searchObat("Paracetamol");
    }

    @And("apoteker menekan tombol hapus obat")
    public void apoteker_menekan_tombol_hapus_obat() {
        obat.showDeleteModal();
    }

    @And("tekan ya pada modal hapus")
    public void tekan_ya_pada_modal_hapus() {
        obat.confirmDelete();
    }


    @Then("muncul pesan data berhasil dihapus")
    public void munculPesanDataBerhasilDihapus() {
            result.showDeleteMsg();
    }

    @Then("tekan tidak pada modal hapus")
    public void tekanTidakPadaModalHapus() {
        result.confirmNegativeDelete();
    }

//    @Then("obat masih tersedia")
//    public void obatMasihTersedia() {
//        Assert.assertFalse(result.tidakAdaDetailDisplayed());
//    }
}
