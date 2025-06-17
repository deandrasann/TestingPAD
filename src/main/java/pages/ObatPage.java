package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ObatPage {
    WebDriver driver;
    public ObatPage (WebDriver driver) {
        this.driver = driver;
    }
    By tambahObatBtn = By.xpath("/html/body/div/div/main/div/div[1]/div[1]/button");
    By namaApoteker = By.id("namaapoteker");
    By namaObat = By.name("nama_obat");
    By bentukObat = By.name("bentuk_obat");
    By golObat = By.name("golongan_obat");
    By ksCreate = By.name("kekuatan_sediaan");
    By kekuatanSediaanEdit   = By.xpath("//*[@id=\"kekuatansediaaneditan\"]");
    By efek = By.name("efek_samping");
    By kontradiksi = By.name("kontraindikasi");
    By indikasi = By.name("indikasi");
    By interaksi = By.name("interaksi_obat");
    By petunjukSimpan = By.name("petunjuk_penyimpanan");
    By polaMakan = By.name("pola_makan");
    By infoTambahan = By.name("informasi_tambahan");
    By simpanBtn = By.xpath("//*[@id=\"tambahObatModal\"]/div/div/form/div[2]/button[2]");

    //Detail Obat
    By searchBar = By.xpath("/html/body/div/div/main/div/div[1]/div[1]/form/div/input");
    By submitSearch = By.xpath("/html/body/div/div/main/div/div[1]/div[1]/form/div/button");
    By detailBtn = By.xpath("/html/body/div/div/main/div/div[1]/div[2]/table/tbody/tr[1]/td[7]/button[1]");

    //Delete
    By deleteBtn = By.xpath("/html/body/div/div/main/div/div[1]/div[2]/table/tbody/tr[1]/td[7]/button[3]");
    By yaDelete = By.xpath("//button[@type='submit' and contains(text(), 'YA')]");


    By editBtn = By.className("editCategory");
    By simpanEditBtn = By.xpath("//*[@id=\"formeditan\"]/div[2]/button[2]");







    public void clickTambahObat() {
        driver.findElement(tambahObatBtn).click();
    }

    public void isiNamaApoteker(String nama) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement apotekerDropdown = wait.until(ExpectedConditions.elementToBeClickable(namaApoteker));
        Select select = new Select(apotekerDropdown);
        select.selectByVisibleText(nama);
    }



    public void isiNamaObat(String nama) {
        driver.findElement(namaObat).sendKeys(nama);
    }

    public void isiBentukObat(String bentuk) {
        driver.findElement(bentukObat).sendKeys(bentuk);
    }

    public void isiGolonganObat(String golongan) {
        driver.findElement(golObat).sendKeys(golongan);
    }
//    public void isiKetersediaan(String kekuatan) {
//        driver.findElement(kekuatanSediaan).sendKeys(kekuatan);
//    }
    public void ksCreate(String ks){
        driver.findElement(ksCreate).sendKeys(ks);
    }

    public void isiKekuatanSediaan(String kekuatan) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement field = wait.until(ExpectedConditions.elementToBeClickable(kekuatanSediaanEdit));
        field.sendKeys(kekuatan);
    }
    public void hapusKekuatanSediaan() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement field = wait.until(ExpectedConditions.elementToBeClickable(kekuatanSediaanEdit));
        field.clear();
    }

    public void isiEfekSamping(String efekSmp) {
        driver.findElement(efek).sendKeys(efekSmp);
    }

    public void isiKontradiksi(String kontra) {
        driver.findElement(kontradiksi).sendKeys(kontra);
    }

    public void isiIndikasi(String indk) {
        driver.findElement(indikasi).sendKeys(indk);
    }

    public void isiInteraksiObat(String interaksiVal) {
        driver.findElement(interaksi).sendKeys(interaksiVal);
    }

    public void isiPetunjukPenyimpanan(String simpan) {
        driver.findElement(petunjukSimpan).sendKeys(simpan);
    }

    public void isiPolaMakan(String pola) {
        driver.findElement(polaMakan).sendKeys(pola);
    }

    public void isiInformasiTambahan(String info) {
        driver.findElement(infoTambahan).sendKeys(info);
    }

    public void showObatBaru() {
        driver.findElement(simpanBtn).click();
    }

    //Detail

    public void searchObat (String namaObat){
        driver.findElement(searchBar).click();
        driver.findElement(searchBar).sendKeys(namaObat);
        driver.findElement(submitSearch).click();
    }
    //Delete
    public void showDetail(){
        driver.findElement(detailBtn).click();
    }
    public void showDeleteModal() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(deleteBtn));
        deleteButton.click();
    }
    public void confirmDelete(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(yaDelete));
        button.click();
    }


    // fix joe
    public void showEditModal(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(editBtn));
        button.click();
    }
    // fix joe
    public void simpanEdit(){
        driver.findElement(simpanEditBtn).click();
    }




}