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

public class TambahObatDefinition {
     WebDriver driver;
     ResultPage result;
    LoginStepHelper loginHelper;
    DashboardPage dashboard;
    ObatPage obat;


    public TambahObatDefinition() {
        this.driver = Hooks.driver; // ambil driver dari Hooks
        this.result = new ResultPage(driver);
        this.loginHelper = new LoginStepHelper(driver);
        this.dashboard = new DashboardPage(driver);
        this.obat = new ObatPage(driver);
    }

    @Given("apoteker berada di beranda")
    public void apoteker_berada_di_dashboard() {
        loginHelper.loginAsApoteker();
        Assertions.assertTrue(result.BerandaDisplayed());
    }

    @When("apoteker mengeklik tombol obat pada sidebar")
    public void apoteker_mengeklik_tombol_obat_pada_sidebar() {
//        dashboard = new DashboardPage(driver);
        dashboard.showObatPage();
    }
    @And("apoteker mengeklik tombol tambah obat")
    public void apoteker_mengeklik_tombol_tambah_obat() {
//        obat = new ObatPage(driver);
        obat.clickTambahObat();
    }
    @And("apoteker mengisi seluruh field dengan valid")
    public void apoteker_mengisi_seluruh_field_dengan_valid() {
        obat.isiNamaApoteker("apoteker1");
        obat.isiNamaObat("Paracetamol");
        obat.isiBentukObat("Tablet");
        obat.isiGolonganObat("Analgesik");
        obat.ksCreate("500");
        obat.isiEfekSamping("Mual, pusing");
        obat.isiKontradiksi("Hindari pada gangguan hati");
        obat.isiIndikasi("Demam dan nyeri ringan");
        obat.isiInteraksiObat("Aspirin, Ibuprofen");
        obat.isiPetunjukPenyimpanan("Simpan di tempat sejuk");
        obat.isiPolaMakan("Sesudah makan");
        obat.isiInformasiTambahan("Tidak untuk anak < 6 tahun");
    }

    @And("apoteker menekan tombol simpan")
    public void apoteker_menekan_tombol_simpan() {
        obat.showObatBaru(); // klik tombol simpan
    }

    @Then("obat berhasil disimpan")
    public void obat_berhasil_disimpan() {
        result.ObatBaruDisplayed();
    }

    @And("apoteker mengkosongkan salah satu field")
    public void apotekerMengkosongkanSalahSatuField() {
        obat.isiNamaApoteker("apoteker1");
        obat.isiNamaObat("Paracetamol");
        obat.isiBentukObat("Tablet");
        obat.isiGolonganObat("Analgesik");
        obat.ksCreate(""); //Kosong
        obat.isiEfekSamping("Mual, pusing");
        obat.isiKontradiksi("Hindari pada gangguan hati");
        obat.isiIndikasi("Demam dan nyeri ringan");
        obat.isiInteraksiObat("Aspirin, Ibuprofen");
        obat.isiPetunjukPenyimpanan("Simpan di tempat sejuk");
        obat.isiPolaMakan("Sesudah makan");
        obat.isiInformasiTambahan("Tidak untuk anak < 6 tahun");
    }

    @And("apoteker menginputkan kekuatan sediaan dengan tipe data string")
    public void apotekerMenginputkanKekuatanSediaanDenganTipeDataString() {
        obat.isiNamaApoteker("apoteker1");
        obat.isiNamaObat("Paracetamol");
        obat.isiBentukObat("Tablet");
        obat.isiGolonganObat("Analgesik");
        obat.ksCreate("500 mg"); //tipe data string
        obat.isiEfekSamping("Mual, pusing");
        obat.isiKontradiksi("Hindari pada gangguan hati");
        obat.isiIndikasi("Demam dan nyeri ringan");
        obat.isiInteraksiObat("Aspirin, Ibuprofen");
        obat.isiPetunjukPenyimpanan("Simpan di tempat sejuk");
        obat.isiPolaMakan("Sesudah makan");
        obat.isiInformasiTambahan("Tidak untuk anak < 6 tahun");
    }

    @Then("tampil pesan error data kosong")
    public void tampilPesanErrorDataKosong() {
        result.errorEmptyFieldDisplayed();
        Assertions.assertTrue(result.errorEmptyFieldDisplayed());
    }

    @Then("tampil pesan salah tipe data")
    public void tampilPesanSalahTipeData() {
        result.errorDataTypeDisplayed();
        Assertions.assertTrue(result.errorDataTypeDisplayed());
    }
}