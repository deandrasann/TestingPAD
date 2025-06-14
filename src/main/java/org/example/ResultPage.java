package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultPage {
    WebDriver driver;
    public ResultPage (WebDriver driver){
        this.driver = driver;
    }
    By beranda = By.xpath("/html/body/div/div/main/div/h2");

}
