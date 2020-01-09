package tests.day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;

public class DropDowns {

    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com");
        driver.findElement(By.linkText("DropDown")).click();
        BrowserUtils.wait(2);
    }

    @Test(description = "Select option 2 from the dropdown")
    public void Test1(){
        // to work with select dropdowns, we need to use Select class in selenium
        // step 1. Find dropdown and create a Web Element
        WebElement dropDown = driver.findElement(By.id("dropdown"));
        // step 2. Create a select object
        Select select = new Select(dropDown);
        // select class requires webElement object as a parameter, to select any option by visible text:
        select.selectByVisibleText("Option 2");
        BrowserUtils.wait(2);
        // How to verify that option 2 is selected?
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Option 2");
        // getFirstSelectedOption()  ===> to get selected option
    }

    @Test(description = "Print list of states")
    public void Test2(){
        WebElement state = driver.findElement(By.id("state"));
        Select select = new Select(state);
        List<WebElement> states = select.getOptions(); // will return available options to select
        // How to print every option , as a text, one by one?
        for (WebElement option : states) {
            System.out.println(option.getText());
        }
    }

    @Test(description = "Select your state and verify that it is selected")
    public void Test3(){
        WebElement state = driver.findElement(By.id("state"));
        Select select = new Select(state);
        select.selectByValue("TN");
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Tennessee");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();

    }
}
