package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    By pasienButton = By.xpath("//a[contains(@href,'/pasien') and contains(.,'Pasien')]");

    public void clickPasienSidebar() {
        driver.findElement(pasienButton).click();
    }

    public boolean isOnPasienPage() {
        return driver.getCurrentUrl().contains("/pasien");
    }

    public boolean isListPasienVisible() {
        // Ganti selector sesuai struktur HTML list pasien
        return driver.findElements(By.cssSelector(".table tbody tr")).size() > 0;
    }
}
