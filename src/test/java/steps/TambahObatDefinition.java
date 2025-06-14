package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.DashboardPage;
import org.example.LoginPage;
import org.example.ObatPage;
import org.example.ResultPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class TambahObatDefinition {
    private WebDriver driver;
    private ResultPage result;
    LoginStepHelper loginHelper;
    DashboardPage dashboard;
    ObatPage obat;


    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("http://127.0.0.1:8000/login");
        driver.manage().window().maximize();
        result = new ResultPage(driver);
        loginHelper = new LoginStepHelper(driver);
    }

    @Given("apoteker berada di dashboard")
    public void apoteker_berada_di_dashboard() {
        loginHelper.loginAsApoteker();
        Assertions.assertTrue(result.BerandaDisplayed());

    }

    @When("apoteker mengeklik tombol obat pada sidebar")
    public void apoteker_mengeklik_tombol_obat_pada_sidebar() {
        dashboard = new DashboardPage(driver);
        dashboard.showObatPage();
    }
    @When("apoteker mengeklik tombol tambah obat")
    public void apoteker_mengeklik_tombol_tambah_obat() {
        obat = new ObatPage(driver);
        obat.clickTambahObat();
    }
    @When("apoteker mengisi seluruh field dengan valid")
    public void apoteker_mengisi_seluruh_field_dengan_valid() {
        obat.isiNamaApoteker("apoteker1");
        obat.isiNamaObat("Paracetamol");
        obat.isiBentukObat("Tablet");
        obat.isiGolonganObat("Analgesik");
        obat.isiKekuatanSediaan("500");
        obat.isiEfekSamping("Mual, pusing");
        obat.isiKontradiksi("Hindari pada gangguan hati");
        obat.isiIndikasi("Demam dan nyeri ringan");
        obat.isiInteraksiObat("Aspirin, Ibuprofen");
        obat.isiPetunjukPenyimpanan("Simpan di tempat sejuk");
        obat.isiPolaMakan("Sesudah makan");
        obat.isiInformasiTambahan("Tidak untuk anak < 6 tahun");
    }

    @When("apoteker menekan tombol simpan")
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
        obat.isiKekuatanSediaan(""); //Kosong
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
        obat.isiKekuatanSediaan("500 mg"); //tipe data string
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


    }

    @Then("tampil pesan salah tipe data")
    public void tampilPesanSalahTipeData() {
        result.errorDataTypeDisplayed();
    }
}
