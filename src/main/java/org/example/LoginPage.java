package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    public LoginPage (WebDriver driver) {
        this.driver = driver;
    }
    By username = By.id("username");
    By password = By.id("password");
    By loginBtn = By.xpath("/html/body/div/div/div[2]/form/div[4]/button");
    public void fillUsername (String usn){
        driver.findElement(username).sendKeys(usn);
    }
    public void fillPassword (String pass){
        driver.findElement(password).sendKeys(pass);
    }
    public void clickLogin(){
        driver.findElement(loginBtn).click();
    }

    By errorMessage = By.id("loginError"); // ID/element dari HTML

    public String getErrorMessage() {
        return driver.findElement(By.id("loginError")).getText(); // Sesuaikan ID dengan HTML login kamu
    }

    public String getErrorMessageText(){
        return driver.findElement(errorMessage).getText();
    }

}
