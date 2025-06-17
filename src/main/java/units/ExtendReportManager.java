package units;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportManager {
    private static ExtentReports extent;
    private static ExtentSparkReporter sparkReporter;
    public static ExtentReports getInstance(){
        if(extent == null){
            String reportPath = System.getProperty("user.dir") + "/test-output/GeneratedExtentReport.html";
            sparkReporter = new ExtentSparkReporter(reportPath);
            sparkReporter.config().setDocumentTitle("Automation Test Report");
            sparkReporter.config().setReportName("Autometion Test Result");
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("Browser", "Chrome");
            extent.setSystemInfo("Tester", "Dea");
            extent.setSystemInfo("Environment", "staging");
        }
        return extent;
    }}
