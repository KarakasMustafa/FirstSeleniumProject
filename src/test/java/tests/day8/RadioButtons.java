package tests.day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

import java.util.List;

public class RadioButtons {
    /*
    TestNG:
        next generation testing. Still, TestNG its a popular testing framework, that is usually used along with a selenium Webdriver
     */

    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practce.cybertekschool.com/");
    }

    @Test(description = "Verify that blue button is selected")
    public void Test1(){
        // to go to radio buttons
        driver.findElement(By.linkText("Radio Buttons")).click();
        WebElement blueButton = driver.findElement(By.id("blue"));
        // lets verify that radio button is checked
        // assert true that button is selected  , if button is selected it will return true, otherwise false
        Assert.assertTrue(blueButton.isSelected());

    }

    @Test(description = "Verify that red button is not selected")
    public void Test2(){
        WebElement redButton = driver.findElement(By.id("red"));
        Assert.assertFalse(redButton.isSelected()); // AssertFalse will expect that condition is false
    }

    @Test(description = "Verify that green button is clickable")
    public void Test3(){
        WebElement greenButton = driver.findElement(By.id("green"));
        Assert.assertFalse(greenButton.isEnabled());
    }


    @Test
    public void Test4(){
        // how to find all radio buttons?
        // find all radio buttons , any radio button will have type ='radio'
        List<WebElement> radioButtons = driver.findElements(By.cssSelector("input[type='radio']"));
        // Lets click only if button  is clicked and available for clicking

        for (WebElement each : radioButtons){
            // if button is available for clicking and not clicked yet
            if(each.isEnabled() && !each.isSelected()){
                each.click(); // then click it
                // in this case, id attribute represents a name of the color
                System.out.println("Button clicked: "+each.getAttribute("id"));

            }else {
                System.out.println("Button was not clicked: "+each.getAttribute("id"));
            }
        }
    }



    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
