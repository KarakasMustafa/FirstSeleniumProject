package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.Set;

public class WindowSwitching {

     /*
    Windows, how to switch in between windows/Tabs
    Frames
    File uploading
    Alerts/Pop-ups

     */

     private WebDriver driver;

     @BeforeMethod
    public void SetUp(){
         driver = BrowserFactory.getDriver("chrome");
         driver.get("http://practice.cybertekschool.com/");
     }

     @Test(description = "Verify that title is still Practice")
     public void Test1(){
         driver.findElement(By.linkText("New tab")).click();
         BrowserUtils.wait(4);
         System.out.println(driver.getTitle());
         Assert.assertEquals(driver.getTitle(), "Practice", "Title is wrong");
     }

     @Test(description = "Verify that user is able to see new window")
     public void test2(){
         driver.findElement(By.linkText("New tab")).click();
         // record id of original window, that we opened initially
         String oldWindow = driver.getWindowHandle();
         // after 3 seconds , another website will be opened, in the second window
         // selenium doesn't switch automatically to the new window
         BrowserUtils.wait(5);
         // in the selenium every window has an id. That id calls window handle
         // To read window handle we use a method getWindowHandle()
         // after new window opened, we can get list of all window id's/window handles
         Set<String> windowHandles = driver.getWindowHandles();
         // Set<> is also a data structure, like List<> , but it doesnt allow duplicates
         // also, you can not easily access anything from there
         // there is no .get() method
         // that's why we need to loop through Set<> , to read a data from there
         // Set<> can store only unique values

         for (String windowHandle : windowHandles){
             if(!windowHandle.equals(oldWindow)){ // if new and old windows are not the same
                 driver.switchTo().window(windowHandle); // Switch to new window
             }
         }
         // lets verify that title of new window is a fresh tab
         System.out.println(driver.getTitle());
         Assert.assertEquals(driver.getTitle(),"Fresh tab", "Title is wrong");

         // come back to original page
         // we can build a function, that will jump in between windows
         // based on page title
         String pageTitle = "Practice";
         for (String windowHandle : windowHandles){
             driver.switchTo().window(windowHandle);
             // if we are on the right page
             if (driver.getTitle().equals(pageTitle)){
                 break;  // just exit
             }
         }
     }


     @AfterMethod
     public void tearDown(){
         driver.quit();
     }
}
