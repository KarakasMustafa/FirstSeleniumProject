package tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        // to maximize browser
        driver.manage().window().maximize();
        driver.get("http://google.com");

        // we want to navigate to the different page
        // within the same browser, we are not going to open new browser or new tab
        driver.navigate().to("http://amazon.com");

        // if we want to come back to the previous page
        driver.navigate().back();

        // if we want to know the URL of current website

        String URL = driver.getCurrentUrl();
        System.out.println(URL);

        driver.close();


    }

}
