package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ResultPage {
    WebDriver driver;
    public ResultPage (WebDriver driver){
        this.driver = driver;
    }
    By beranda = By.xpath("/html/body/div/div/main/div/h2");
    By alertSuccess = By.cssSelector(".alert.alert-success");
    By errorDataType = (By.xpath("//small"));
    By errorEmptyFill = (By.xpath("//small"));
    By modalDetailObat = (By.id("detailObatModalLabel"));
    By tidakAdaDetail = (By.id("/html/body/div/div/main/div/div[1]/div[2]/table/tbody/tr/td"));
    By deletedMsg = By.xpath("/html/body/div/div/main/div/div[1]");
    By editSuccessMsg = By.xpath("/html/body/div/div/main/div/div[1]");
    By tidakDelete = By.xpath("//button[@type='button' and contains(text(), 'TIDAK')]");
    By dataPasien = By.xpath("/html/body/div/div/main/div[1]/div[1]/h2");



    public boolean BerandaDisplayed() {
        return driver.findElement(beranda).isDisplayed();
    }

    public boolean ObatBaruDisplayed() {
        return driver.findElement(alertSuccess).isDisplayed();
    }
    public boolean errorDataTypeDisplayed(){
        return driver.findElement(errorDataType).isDisplayed();
    }
    public boolean errorEmptyFieldDisplayed(){
        return driver.findElement(errorEmptyFill).isDisplayed();
    }
    public boolean detailObatDisplayed(){return driver.findElement(modalDetailObat).isDisplayed();}
    public boolean tidakAdaDetailDisplayed(){return driver.findElement(modalDetailObat).isDisplayed();}
    public boolean showDeleteMsg(){
        return driver.findElement(deletedMsg).isDisplayed();
    }

    //fix joe
    public boolean showEditMsg(){
        return driver.findElement(editSuccessMsg).isDisplayed();
    }
    public void confirmNegativeDelete(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement btnTidak = wait.until(ExpectedConditions.elementToBeClickable(tidakDelete));
        btnTidak.click();

//        driver.findElement(tidakDelete).click();
    }
    public boolean dataPasienDisplayed(){
        return  driver.findElement(dataPasien).isDisplayed();
    }


}