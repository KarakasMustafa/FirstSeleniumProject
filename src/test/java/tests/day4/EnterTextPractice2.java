package tests.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class EnterTextPractice2 {
    /*
        1.Go to "http://practice.cybertekschool.com/forgot_password"  page
        2.Enter any valid email
        3.Click on retrieve password button
        4.Verify that message "Your e-mail's been sent!" is displayed

     */
    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");

        WebElement input = driver.findElement(By.name("email"));
        input.sendKeys("random@gmail.com", Keys.ENTER);
        // Keys.ENTER will simulate ENTER button press

        BrowserUtils.wait(3);

        WebElement confirm = driver.findElement(By.name("confirmation_message"));
        String expectedMessage = "Your e-mail's been sent!";
        String actualMessage = confirm.getText();  // to get the text from the element

        if(expectedMessage.equals(actualMessage)){
            System.out.println("Test passed");
        }else {
            System.out.println("Test failed");
        }

        BrowserUtils.wait(2);
        driver.close();


    }
}
