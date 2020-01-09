package tests.day9;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class TestNGReview {

    // Whatever is common among tests, can go into @BeforeMethod and @AfterMethod
    // @Test annotation is required ,all other methods are optional
    // @BeforeMethod and @AfterMethod runs always before and after every Test
    // if we close the driver in @AfterMethod , we must initialize it in @BeforeMethod

    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.out.println("Before Method");
        driver = BrowserFactory.getDriver("chrome");
    }

    @Test(description = "Verify title of google.com",priority = 2) // if we run all together, priority matters to run first.
    public void Test1(){
        System.out.println("Test 1");
        driver.get("http://google.com");
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"Not matching");
    }

    @Test(description = "Verify the title of apple.com", priority = 1)
    public void VerifyApplePageTitle(){
        System.out.println("Test 2");
        driver.get("https://www.apple.com/");
        String expectedTitle = "Apple";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"Titles are not matching!");
    }

    // Data provider can supply with a test data. Also , it allows to do Data Driven Testing.
    // What is this? Its when same test runs multiple times with different test data set
    @DataProvider(name = "TestData")
    public static Object[][] testData(){
        return new Object[][]{{"https://www.apple.com/","Apple"}, {"http://google.com","Google"}};
    }

    //data provider must return 2D array of Object
    // 1st parameter = 1 object in the inner array, 2nd parameter = 2 object in the inner array
    // url = "https://www.apple.com/" , title = "Apple"

    @Test(dataProvider = "TestData")
    public void testWithDataProvider(String url , String title){
        driver.get(url);
        Assert.assertEquals(driver.getTitle(), title);
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("After Method!");
        driver.quit();
    }


}
