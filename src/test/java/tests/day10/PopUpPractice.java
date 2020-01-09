package tests.day10;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class PopUpPractice {

    private WebDriver driver;

    @BeforeMethod
    public void SetUp(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
    }

    @Test(description = "Click ok on pop up")
    public void Test1(){
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        driver.findElement(By.xpath("//button[text()=\"Click for JS Alert\"]"));
        BrowserUtils.wait(2);
        Alert alert = driver.switchTo().alert();
        alert.accept();  // to click ok
        BrowserUtils.wait(2);
    }


    @Test(description = "Click on Cancel on pop-up")
    public void Test2(){
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        driver.findElement(By.xpath("//button[2]")).click();
        BrowserUtils.wait(2);
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText()); // Print pop-up text message
        alert.dismiss(); // to click cancel
    }


    @Test(description = "Click on button 3, enter some text and then click ok")
    public void Test3(){
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        driver.findElement(By.xpath("//button[3]")).click();
        BrowserUtils.wait(2);
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Yeah!");
        BrowserUtils.wait(2);
        alert.accept();
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
