package tests.day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigurationReader;

public class ConfigReaderTest {

    /*
     We use configuration.properties file for project configuration.
     In this file, we usually store URLs.
     dev environment ==> qa environment | another qa environment ==> pre-production environment ==> production environment
     dev.vytrack.com , qa.vytrack.com, qa2.vytrack.com, preprod.vytrack.com, vytrack.com
     Every environment has a different link, And to manage these links better, we store them in the config file
     Also we store credentials , data base configuration info , some wait time(for explicit wait)
     if key name  is wrong, you will get ===> null

     =================================
     I believe it's not very cool to create new driver in every class. So what if we have one central place,
     that will create driver. In this way, every test will use same driver. We will make process of drive switch
     match easier

     In OOP we have Design Patterns.
     It's a proven solution for specific task.

     One of the most popular design pattern for WebDriver in Selenium is Singleton.

     Singleton - means single object of something for entire project.
     What's the point?  --> this object will be static and we can ensure that all tests use same driver object. So we can
     create test suits.

     Also, Whenever we need to use driver, we will just call it from Driver Class. And it's gonna be same driver
     for everyone.

     Otherwise, new WebDriver object = new Browser.
     With this design, driver will be sharable and easy to access.

     What are the conventions of singleton pattern?
     - private static instance
     - private constructor (to prevent class instantiation)
     - public getter that returns private static instance

     class Driver(){
        // only one private static instance
        private static WebDriver driver;

        // to prevent class instantiation
        private Driver(){
        }

        public static WebDriver get(){

           // if object was not created yet - create it

           if(driver == null){
            driver = new ChromeDriver();
            }

            return driver;
        }
      }



     */


    @Test
    public void Test1(){
        String expectedBrowser = "chrome";
        // We write Keys in "key" as a String
        // as return, you will get value, key = value , property name = value
        // we don't change property names, we change values
        // the idea is change in the one place, and affect entire frameWork
        // let's say every class will read browser type from properties file
        // and to perform cross-browsing testing, we can easily change value of apply it so it will be changed everywhere

        String actualBrowser = ConfigurationReader.getProperty("browser");
        Assert.assertEquals(actualBrowser,expectedBrowser);
        // Read value of url property
        System.out.println("URL: "+ ConfigurationReader.getProperty("Url"));
        // read value of user_name property
        System.out.println("UserName: "+ ConfigurationReader.getProperty("user_name"));
        // read value of password property
        System.out.println("Password: " + ConfigurationReader.getProperty("password"));
    }
}
