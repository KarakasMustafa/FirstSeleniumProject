package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class ActionsPractice {

    private WebDriver driver;

    @BeforeMethod
    public void SetUp(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/hovers");
    }

    @Test(description = "Verify First Image")
    public void Test1(){
        Actions action = new Actions(driver);  // Create object of actions to perform actions(drag and drop, context click, )
        WebElement image1 = driver.findElement(By.cssSelector(".figure:nth-of-type(1)"));
        // just to hover on element , not click
        action.moveToElement(image1).perform(); // build() is required when we have more than 1 action in a chain
        BrowserUtils.wait(2);

        WebElement textOfImage1 = driver.findElement(By.cssSelector(".figure:nth-of-type(1) h5"));
        // h5 is grandchild of .figure:nth-of-type(1) , this element that contains image
        String expectedText = "name: user1";
        String actualText = textOfImage1.getText();
        Assert.assertEquals(actualText,expectedText,"not matching!");
    }

    @Test(description = "Verify all images")
    public void test2(){
        Actions action = new Actions(driver);
        for(int i=1; i<=3; i++){
            action.moveToElement(driver.findElement(By.cssSelector(".figure:nth-of-type("+i+")"))).perform();
            BrowserUtils.wait(2);
            String name = driver.findElement(By.cssSelector(".figure:nth-of-type("+i+") h5")).getText();
            System.out.println(name);
            Assert.assertEquals(name,"name: user"+i);
        }
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
