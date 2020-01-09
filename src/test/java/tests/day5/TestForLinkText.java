package tests.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class TestForLinkText {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");

        WebElement linkText = driver.findElement(By.linkText("Autocomplete"));
        System.out.println(linkText.getText());
        linkText.click();

        Thread.sleep(3000);

    }
}
