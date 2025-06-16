package steps;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void setUp() {
        if (driver == null) {
            driver = new ChromeDriver();
            driver.get("http://127.0.0.1:8000/login");
            driver.manage().window().maximize();
        }
    }

//    @After
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//            driver = null;
//        }
//    }
}
