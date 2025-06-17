package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultPage {
    WebDriver driver;
    public ResultPage (WebDriver driver){
        this.driver = driver;
    }
    By beranda = By.xpath("/html/body/div/div/main/div/h2");
    By alertSuccess = By.cssSelector(".alert.alert-success");
    By errorDataType = (By.xpath("//small[contains(text(), 'Harus berupa angka')]"));
    By errorEmptyFill = (By.xpath("//small[contains(text(), 'Field ini wajib diisi')]"));

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

}