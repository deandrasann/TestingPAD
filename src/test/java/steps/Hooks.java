package steps;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import units.ExtendReportManager;
import units.ScreenShootUtil;

public class Hooks {
    public static WebDriver driver;
    public static ExtentReports extent;
    public static ExtentTest test;

    @Before
    public void setUp(Scenario scenario) {
        if (driver == null) {
            driver = new ChromeDriver();
            driver.get("http://127.0.0.1:8000/login");
            driver.manage().window().maximize();

            extent = ExtendReportManager.getInstance();
            test = extent.createTest(scenario.getName());
            test.log(Status.INFO, "Starting scenario: " + scenario.getName());
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotPath = ScreenShootUtil.capture(driver, scenario.getName().replace(" ", "_"));
            try {
                test.addScreenCaptureFromPath(screenshotPath);
            } catch (Exception e) {
                test.log(Status.WARNING, "Gagal menambahkan screenshot: " + e.getMessage());
            }
            test.log(Status.FAIL, "Scenario failed");
        } else {
            test.log(Status.PASS, "Scenario passed");
        }
        driver.quit(); // jangan lupa tutup browser
        extent.flush();
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
