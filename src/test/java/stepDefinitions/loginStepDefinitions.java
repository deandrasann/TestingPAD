package stepDefinitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import org.example.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.ExtentReportManager;
import utils.ScreenshotUtil;

import java.time.Duration;

public class loginStepDefinitions {
    WebDriver driver;
    LoginPage loginPage;

    private static ExtentReports extent = ExtentReportManager.getInstance();
    private static ExtentTest test;

    @Before
    public void setup(Scenario scenario) {
        test = extent.createTest(scenario.getName());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        test.log(Status.INFO, "Browser launched and maximized.");
    }

    @After
    public void teardown(Scenario scenario) {
        if (scenario.isFailed()) {
            test.log(Status.FAIL, "Scenario failed: " + scenario.getName());
            String screenshotPath = ScreenshotUtil.takeScreenshot(driver, scenario.getName().replaceAll(" ", "_"));
            try {
                test.addScreenCaptureFromPath(screenshotPath, "Failed Screenshot");
            } catch (Exception e) {
                test.log(Status.WARNING, "Failed to attach screenshot: " + e.getMessage());
            }
        } else {
            test.log(Status.PASS, "Scenario passed: " + scenario.getName());
        }

        if (driver != null) {
            driver.quit();
            test.log(Status.INFO, "Browser closed.");
        }

        extent.flush();
    }

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        driver.manage().window().maximize();
        driver.get("http://127.0.0.1:8000/login");
        loginPage = new LoginPage(driver);
    }

    @When("User enters valid username and password")
    public void user_enters_valid_username_and_password() {
        loginPage.fillUsername("apoteker1");
        loginPage.fillPassword("apoteker123");
    }

    @When("User clicks the login button")
    public void user_clicks_the_login_button() {
        loginPage.clickLogin();
    }

    @Then("User should be redirected to the dashboard")
    public void user_should_be_redirected_to_the_dashboard() {
        String currentUrl = driver.getCurrentUrl(); // ← Tambah baris ini
        System.out.println("Current URL: " + currentUrl); // ← Tambah baris ini
        Assert.assertTrue(currentUrl.contains("/beranda"), "User not redirected to dashboard");
        driver.quit();
    }

    @When("User enters valid username {string}")
    public void user_enters_valid_username(String username) {
        loginPage.fillUsername(username);
    }

    @When("User enters invalid password {string}")
    public void user_enters_invalid_password(String password) {
        loginPage.fillPassword(password);
    }
    @Then("An error message {string} should be displayed")
    public void an_error_message_should_be_displayed(String expectedMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginError"))); // GANTI jika ID berbeda
        String actualMessage = errorElement.getText().trim();
        Assert.assertEquals(actualMessage, expectedMessage);
    }



}