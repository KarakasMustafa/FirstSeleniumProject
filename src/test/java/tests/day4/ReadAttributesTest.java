package tests.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class ReadAttributesTest {

    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");

        WebElement input = driver.findElement(By.name("email"));

        // to read value of any attribute
        // name ="email" name is an attribute, email is a value of attribute

        System.out.println(input.getAttribute("pattern"));
        input.sendKeys("random@gmail.com");

        // how to read entered text?
        // its gonna be inside value attribute
        System.out.println(input.getAttribute("value"));

        // if button has the type "submit"
        // we can use  .submit() method instead of .click()

        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        // alternative to click , only if type = "submit"
        retrievePasswordButton.submit();
        driver.close();
    }
}
