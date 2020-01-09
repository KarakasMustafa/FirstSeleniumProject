package tests.Homeworks;

import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.ArrayList;
import java.util.Arrays;

public class HomeWork2WithForLoop {
    public static void main(String[] args) {

        ArrayList<String> urls = new ArrayList<String>(Arrays.asList("http://practice.cybertekschool.com/",
                "http://practice.cybertekschool.com/dropdown", "http://practice.cybertekschool.com/login"));
        WebDriver driver = BrowserFactory.getDriver("chrome");
        String [] Titles = new String[urls.size()];

        for(int i=0; i<urls.size(); i++){
            driver.get(urls.get(i));
            BrowserUtils.wait(2);
            Titles[i] = driver.getTitle();
        }
        // I just tried to call all ArrayList and Title Array in a for loop

        for(int i=0; i<Titles.length-1; i++){
            if(Titles[i].equals(Titles[i+1])){
                System.out.println("Title "+(i+1)+ " is "+Titles[i]);
            }
        }

        driver.close();


    }
}
