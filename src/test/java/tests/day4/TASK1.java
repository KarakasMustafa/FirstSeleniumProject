package tests.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TASK1 {

    /*
    /// TASK 1:

        Go to  http://practice.cybertekschool.com/forgot_password
        Click on the retrieve password button
        Verify that page title didnt change (in this case, we verify that same page is still opened)
     */
    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");

        String expectedTitle = driver.getTitle();
        WebElement button = driver.findElement(By.id("form_submit"));
        button.click();
        BrowserUtils.wait(3);  // wait 3 seconds

        String actualTitle = driver.getTitle(); // get the Title

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }


        driver.close();

    }



}
