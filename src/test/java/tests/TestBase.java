package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.BrowserUtils;
import utils.ConfigurationReader;
import utils.Driver;

import java.io.IOException;

// This will be a test foundation for all test classes
// We will put here only BeforeMethod and AfterMethod
// In this way before and after methods will be the same
// Every test class  will extend testBase class

public abstract class TestBase {
  /*
     * ExtentReports itself does not build any reports, but allows reporters to access information, which in
     * turn build the said reports. An example of building an HTML report and adding information to ExtentX:
     * ExtentHtmlReporter html = new ExtentHtmlReporter("Extent.html");
     * ExtentXReporter extentx = new ExtentXReporter("localhost");

   */

    protected static ExtentReports extentReports; // reports file
//  The ExtentHtmlReporter creates a rich standalone HTML file. It allows several
    protected static ExtentHtmlReporter extentHtmlReporter; // report
//  Defines a test. You can add logs, snapshots, assign author and categories to a test and its children.
    protected static ExtentTest extentTest; // writer(report)

    @BeforeTest
    @Parameters({"test", "env_url"}) // parameters' coming from the testng.xml --> <parameter name="test" value="regression"></parameter>
    public void beforeTest(@Optional String test, @Optional String env_url){

        String reportName = "report";
        if(test != null){
            reportName = test;
        }
//      Location of report
//      its gonna be next to target folder, test-output folder
        String filePath = System.getProperty("user-dir") + "/test-output/" + reportName + ".html";
        extentReports = new ExtentReports();
        extentHtmlReporter = new ExtentHtmlReporter(filePath);
        extentReports.attachReporter(extentHtmlReporter);
        extentHtmlReporter.config().setReportName("Vytrack Test Results");

        // System information
        String env = ConfigurationReader.getProperty("Url");
        if(env_url != null){
            env = env_url;
        }
        extentReports.setSystemInfo("Environment", env);
        extentReports.setSystemInfo("Browser", ConfigurationReader.getProperty("browser"));
        extentReports.setSystemInfo("OS",System.getProperty("os.name"));
    }

    @BeforeMethod
    @Parameters("env_url") //   ==> coming from smoke_test.xml file
    public void SetUp(@Optional String env_url){
        String url = ConfigurationReader.getProperty("Url");
        // if name parameter was set, then use it
        // if it's null
        if(env_url != null){
            url = env_url;
        }
        Driver.get().get(url);

    }

    // ITestResult class describes the result of a test. (in TestNG )
    @AfterMethod
    public void tearDown(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE){
            extentTest.fail(result.getName());
            extentTest.fail(result.getThrowable());
            try {
                // BrowserUtils.getScreenshot(result.getName()) => takes screenshot and returns location of that screenshot
                // this method throws IOException (Which is checked Exception)
                // every checked exception must be handled right away
                extentTest.addScreenCaptureFromPath(BrowserUtils.getScreenshot(result.getName()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if(result.getStatus() == ITestResult.SKIP){
            extentTest.skip("Test case was skipped : "+ result.getName());
        }
        Driver.close();
    }

    @AfterTest
    public void afterTest(){
        // Writes test information from the started reports to their output view
        extentReports.flush();
    }


}
