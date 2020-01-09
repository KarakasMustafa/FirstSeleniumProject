package tests.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class TestForTagNameLocator {
    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/sign_up");
        driver.findElement(By.name("full_name")).sendKeys("To User");
        driver.findElement(By.name("email")).sendKeys("random@gmail.com");
        driver.findElement(By.name("wooden_spoon")).click();

        WebElement tag = driver.findElement(By.tagName("h3")); // Get the tag name of the page

        System.out.println(tag.getText()); // should get "Home" on the display


    }
}
