package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ResultPage {
    WebDriver driver;
    public ResultPage (WebDriver driver){
        this.driver = driver;
    }
    By beranda = By.xpath("/html/body/div/div/main/div/h2");

    public void berandaDisplayed(){
        Assert.assertTrue(driver.findElement(beranda).isDisplayed(), "Beranda tidak tampil");
    }
}
