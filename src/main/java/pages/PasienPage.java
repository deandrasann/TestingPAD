package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasienPage {
        WebDriver driver;
        public PasienPage (WebDriver driver) {
            this.driver = driver;
        }
        By logOutBtn = By.xpath("/html/body/nav/div/div[2]/form/a");
        public void clickLogOut(){
            driver.findElement(logOutBtn).click();
        }

}
