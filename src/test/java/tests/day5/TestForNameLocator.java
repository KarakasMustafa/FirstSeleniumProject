package tests.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TestForNameLocator {

    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");
        WebElement FullName = driver.findElement(By.name("full_name")); // find the location to send name
            FullName.sendKeys("Mustafa K"); // Send name to the full name locatoe
        BrowserUtils.wait(2);
        WebElement email = driver.findElement(By.name("email"));    // find locator for email
            email.sendKeys("random@gmail.com");     // send my email to the locator
        BrowserUtils.wait(1);
        WebElement button = driver.findElement(By.name("wooden_spoon")); // find the sign up button
            button.click();
        BrowserUtils.wait(2);
            driver.close();

    }
}
