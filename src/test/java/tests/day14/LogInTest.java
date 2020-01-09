package tests.day14;

import org.testng.annotations.Test;
import utils.BrowserUtils;
import utils.ConfigurationReader;
import utils.Driver;

public class LogInTest {

    @Test
    public void Test1(){
        // Read Url's value from Properties file
        String url = ConfigurationReader.getProperty("Url");
        // Driver.get() ===> will return WebDriver object
        // and then we can call WebDriver methods like get(), findElement()...

        Driver.get().get(url);

        // print page Title
        System.out.println(Driver.get().getTitle());
        BrowserUtils.wait(2);
        Driver.close();

    }
}
