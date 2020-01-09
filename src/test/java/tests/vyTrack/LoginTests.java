package tests.vyTrack;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import tests.TestBase;
import utils.Driver;

// We write extends TestBase to inherit @Before and @After methods
// this class will be dedicated to tests related to Login page only
// We don't have to find elements here
// We should find elements in page classes only
public class LoginTests extends TestBase {

    @Test(description = "Verify that page title is a 'Dashboard' ")
    public void Test1(){
        // Create page object
        LoginPage loginPage = new LoginPage();
        // call login method and insert username and password
        loginPage.login("storemanager85", "UserUser123");
        // Verify Title
        // Driver.get() == driver  // same things, both are WebDriver objects
        // explicit wait for Title
        WebDriverWait wait = new WebDriverWait(Driver.get(), 10);
        wait.until(ExpectedConditions.titleIs("Dashboard"));
        Assert.assertEquals(Driver.get().getTitle(),"Dashboard");
    }
}
