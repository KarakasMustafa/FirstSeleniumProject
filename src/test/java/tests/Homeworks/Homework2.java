package tests.Homeworks;

import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.ArrayList;
import java.util.Arrays;

public class Homework2 { // Title Verification

    public static void main(String[] args) {

        ArrayList<String> urls = new ArrayList<String>(Arrays.asList("http://practice.cybertekschool.com/",
                "http://practice.cybertekschool.com/dropdown","http://practice.cybertekschool.com/login"));
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get(urls.get(0));

        String Title1 = driver.getTitle();
        BrowserUtils.wait(2);

        driver.navigate().to(urls.get(1));
        String Title2 = driver.getTitle();
        BrowserUtils.wait(2);

        driver.navigate().to(urls.get(2));
        String Title3 = driver.getTitle();
        BrowserUtils.wait(2);

        if(Title1.equals(Title2) && Title1.equals(Title3)){
            System.out.println("All Titles are the same");
        }else{
            System.out.println("Titles are different");
        }

        driver.close();


    }


}
