package tests.vyTrack;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import tests.TestBase;

public class NewCalenderEventsTest extends TestBase {

    @Test(description = "Verify that page subtitle is equal to 'All Calender Events' ")
    public void Test1(){
        // this step is required for every test
        // Otherwise you will gwt NullPointerException
        // you must create a test at the beginning

        extentTest = extentReports.createTest("Verify that page subtitle is equal to 'All Calender Events' ");
        LoginPage loginPage = new LoginPage();

        loginPage.login("storemanager85","UserUser123");
        loginPage.navigateTo("Activities","Calendar Events");

        String expectedSubtitle = "All Calendar Events";
        String actualSubtitle = loginPage.getPageSubTitle();

        Assert.assertEquals(expectedSubtitle,actualSubtitle);

        extentTest.pass("Verified that page subtitle 'All Calender Events' is displayed");

    }
}
