package tests.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TestsForClassNameLocator {

    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        BrowserUtils.wait(1);
        driver.navigate().to("http://practice.cybertekschool.com/multiple_buttons");
        WebElement heading = driver.findElement(By.className("h3")); // find the Attribute for HEADING
        System.out.println(heading.getText());  // Get the text of Heading

        WebElement result = driver.findElement(By.className("h4")); // Get the result Attribute for RESULT
        System.out.println(result.getText()); // Get the result Text "Result:"
        BrowserUtils.wait(2);
        driver.close();

    }
}
