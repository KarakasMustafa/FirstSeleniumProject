package tests.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstAutomationScript {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://google.com");

        // to read page title, there is a method .getTitle();

        // Test 1. Verify that title of page is "Google"

        String actualResult = driver.getTitle();
        String expectedResult = "Google";

        if(actualResult.equals(expectedResult)){
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed");
        }

        // to close the browser
        // it has to be at the end of the test execution
        // if we opened a gate, we must close it.
        driver.close();

        /*
        Dependency :
            Used inside a pom.xml file. pom.xml its a brain of maven project.
            We create maven project, its like better organized project.

         */


    }
}
