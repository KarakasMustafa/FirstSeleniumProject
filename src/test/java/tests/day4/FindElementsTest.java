package tests.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class FindElementsTest {

    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        // Step 1: Open inspector in chrome and find locator for the element
        // Step 2: Create object of WebElement
        // Step 3: Use the WebElement

        WebElement button = driver.findElement(By.id("form_submit"));
        button.click();  // To click on the element
        BrowserUtils.wait(3);  // wait 3 seconds
        driver.close(); // close the driver.

        /*
        Open inspector in Chrome. Right click ===> inspect.
        in the inspector we are reading a source to create locators.

        Locator, its the thing that helps selenium to find element, and later work with that element,
        For example : click,enter text, read text/attributes, select etc.

        Interface is like class, but has different purpose.

        WebElement represents any kind of element on the page.

        ***
        When  we have a task, to automate something, first you need to read and analyze.
        Based on acceptance criteria/business requirements we develop test scripts.Before any automation,
        test it manually

        /// For automation  ///

        First we need to find elements. For this, we have 8 locators.

        id
        name
        tagname
        className
        xpath
        cssSelector
        linkText
        partialLinkText

        As of today, we are using "id"

        id its the best way to find element. ID must be unique.Also, in terms of performance,
        its the fastest way to find element.

        WebElement element = new WebElement();     // it will not work

        Because of interface.

        Instead, we do:

        WebElement element = driver.findElement(By.id("value"));

        Then, to click ,  we use .click() method

        element.click();





         */






    }
}
