package tests.day3;

import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class NavigationPractice {
    public static void main(String[] args) {

        /*
        driver.get(URL);
        driver.manage().window().
         */

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();  // to maximize browser window
        driver.get("http://google.com"); // go to google page

        // to get the title of the page
        System.out.println(driver.getTitle());

        // Wait for 3 sec on the page:
        BrowserUtils.wait(3);

        driver.navigate().to("http://amazon.com"); // to navigate browser to amazon
        driver.navigate().back(); // navigate back to google.
        driver.navigate().forward();  // to forward the browser (amazon for this task)
        driver.navigate().refresh(); // to refresh the page

        driver.quit();  // to shut down the browser

        // driver.get("http://google.com");
        // we can not call driver after used quit() method
        // we have to recreate an object of WebDriver.

        // if we use close() method ??
        // if there is only one tab, it will be same as quit()
        // if its more than one tab, we still can use the driver

        /*
        SUMMARY:

            getTitle() ==> to get page title
            getCurrentUrl()  ==> to get the URL of the current website
            close()  ==>  to close current tab. if its a last tab, it will also shutdown the browser and session
            quit()  ==>  to close all tabs that were opened by WebDriver
            navigate().to(URL)  ==>  to jump to other website.It will not open a new tab/Browser
            navigate().back()  ==>  comeback to previous website
            navigate().forward()  ==> to move forward in the browser history
            navigate().refresh()  ==> to refresh the wabsite
            manage().window().maximize()  ==> to maximize window
            manage().window().fullscreen()  ==> to run it in the fullscreen

         */




    }
}
