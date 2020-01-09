package tests.day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import  utils.BrowserFactory;

public class BrowserFactoryTest {

    public static void main(String[] args) {
        // We can get webdriver like this
        // getDriver() method will return a webdriver
        WebDriver driver = BrowserFactory.getDriver("chrome");

        // how can we print a source code of the page?
        driver.get("http://practice.cybertekschool.com");
        System.out.println(driver.getPageSource());

        // to finish test execution.
        driver.quit();


    }


}
