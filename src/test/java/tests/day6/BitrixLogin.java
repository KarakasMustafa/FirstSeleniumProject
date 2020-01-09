package tests.day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class BitrixLogin {

    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://login1.nextbasecrm.com/?login=yes");
        BrowserUtils.wait(1);
        WebElement email = driver.findElement(By.xpath("//*[@id=\"login-popup\"]/form/div[1]/div[1]/input"));
        email.sendKeys("helpdesk59@cybertekschool.com");
        WebElement password = driver.findElement(By.xpath("//*[@id=\"login-popup\"]/form/div[1]/div[2]/input"));
        password.sendKeys("UserUser");
        BrowserUtils.wait(1);
        driver.findElement(By.xpath("//*[@id=\"login-popup\"]/form/div[2]/input")).click();

    }
}

// Teachers codes
/*

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
public class BitrixLogin {
//    helpdesk59@cybertekschool.com
//            UserUser
    public static void main(String[] args) {
        //getDriver() method returns object of webdriver
        //we need webdriver object to send commands to the brwoser
        //left side is a reference variable to reuse this object
        //object can be created and used without reference variable,
        //but it's gonna be impossible to use that object more than once.
        WebDriver driver = BrowserFactory.getDriver("chrome");
        //go to bitrix
        driver.get("https://login1.nextbasecrm.com/?login=yes");
        //enter email
        //WebElement email = driver.findElement("");
        //email.sendKeys("email@email.com");
        // Using a Xpath and its way quicker
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("helpdesk59@cybertekschool.com");
        //enter password
        // * matches any element
        //it's better to specify tag name, to avoid issues with finding element
        driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("UserUser");
    }
}





 */