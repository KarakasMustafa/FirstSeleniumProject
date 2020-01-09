package tests.Homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWorks {
    public static void main(String[] args) {

        // Homework 1:
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://google.com");
        String firstTitle = driver.getTitle();

        int sec = 2;
        try {
            Thread.sleep(1000*sec);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        driver.navigate().to("https://etsy.com");
        String secondTitle = driver.getTitle();

        driver.navigate().back();
        if(firstTitle.equals(driver.getTitle())){
            System.out.println("Same title for the first step");
        }

        try {
            Thread.sleep(1000*sec);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        driver.navigate().forward();

        if(secondTitle.equals(driver.getTitle())){
            System.out.println("second title is same");
        }

        driver.close();

    }
}
