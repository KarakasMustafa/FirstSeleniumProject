package tests.day9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class LocatorsReview {

    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
    }

    @Test(description = "Verify Checkboxes")
    public void VerifyCheckBoxes(){
        driver.findElement(By.linkText("Checkboxes")).click();
        // [type='checkbox'] since there are 2 elements with same locator,
        // and I need only first one , I can use in css,  :nth-of-type(index) 7th, 8th etc.
        // its very useful if you have more than one element under same css selector
        // any tag or tag + attributes :nth-of-type(index)
        WebElement checkbox1 = driver.findElement(By.cssSelector("[type='checkbox']:nth-of-type(1)"));

        // How to verify if check box is not clicked?
        Assert.assertFalse(checkbox1.isSelected()); // assert that checkbox is not selected

        WebElement checkbox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
        Assert.assertFalse(checkbox2.isSelected(),"Its selected Already!"); // if its selcted if will return true, so it will display the message
        // again, css selector is preferable, because of speed.
    }


    @Test(description = "Radio buttons test")
    public void RadioButtons(){
        driver.findElement(By.linkText("Radio Buttons")).click();
        WebElement BlueButton = driver.findElement(By.xpath("//*[text()='Blue']/preceding-siblings::input[@type='radio']"));
        Assert.assertTrue(BlueButton.isSelected(),"Blue button is not selected");
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
