package tests.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class EnterTextPractice {

    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");

        /*
        To enter the text, we use  .sendKeys("text")  method
        locator - its an address of element on the page. There are different locators,
        but the goal is the same - to find element.
         */

        driver.get("http://practice.cybertekschool.com/forgot_password");
        WebElement inputBox = driver.findElement(By.name("email"));
        inputBox.sendKeys("random@gmail.com");

        BrowserUtils.wait(2);

        /*
        Test 2, Verify that email changed

        1.Go to "http://practice.cybertekschool.com/forgot_password"  page
        2.Enter any valid email
        3.Click on retrieve password button
        4.Verify that URL is equals to "http://practice.cybertekschool.com/email_sent"

         */
        String expectedURL = "http://practice.cybertekschool.com/email_sent";


        WebElement button = driver.findElement(By.id("form_submit"));
        button.click();
        String actualURL = driver.getCurrentUrl();
        BrowserUtils.wait(2);

        if(expectedURL.equals(actualURL)){
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed");
        }

        driver.close();
    }
}
