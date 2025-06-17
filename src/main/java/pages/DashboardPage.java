package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

    WebDriver driver;
    public DashboardPage (WebDriver driver) {
        this.driver = driver;
    }
    By obatBtn = By.xpath("//*[@id=\"sidebar-nav\"]/a[3]");

    public void showObatPage() {
        driver.findElement(obatBtn).click();
    }

    By pasienBtn = By.xpath("//*[@id=\"sidebar-nav\"]/a[4]");
    public void showPasienPage(){
        driver.findElement(pasienBtn).click();
    }

}