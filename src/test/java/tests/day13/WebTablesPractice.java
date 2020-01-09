package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

import java.util.List;

public class WebTablesPractice {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void SetUp(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/tables");
        wait = new WebDriverWait(driver,15);
    }

    @Test(description = "Print table 1 data")
    public void Test1(){
        // <table> stands for web table in HTML
        // table1 is id of first table
        // to prevent getting NoSuchElementException we use explicit wait
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("table1")));
        WebElement table = driver.findElement(By.id("table1")); // table1 is id of first table
        // once we find this table as web element , we can print all text from there
        System.out.println(table.getText());
    }

    @Test(description = "Verify that number of columns in the first table is equals 6")
    public void Test2(){
        // wait for presence of table 1
        // size = amount of elements
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("table1")));
        int actualColumnsNumber = driver.findElements(By.xpath("//table[@id='table1']//th")).size();
        int expectedColumnsNumber = 6;
        Assert.assertEquals(actualColumnsNumber,expectedColumnsNumber);
    }

    // to exclude first row (thead row) = //table1[@id='table1']//tbody//tr
    // "//" means any child, in this case any tr element of the table
    @Test(description = "Verify that Number of Rows is == 5")
    public void Test3(){
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("")));
        int actualRowCount = driver.findElements(By.xpath("//table[@id='table1']//tr")).size();
        int expectedRowCount = 5;
        Assert.assertEquals(actualRowCount,expectedRowCount);
    }

    @Test(description = "Print all values from the 2nd row (Excluding table header)")
    public void Test4() {
        List<WebElement> secondRow = driver.findElements(By.xpath("//*[@id='table1']/tbody/tr[2]/td"));
        for (WebElement each : secondRow) {
            System.out.println(each.getText());
        }
    }

    @Test(description = "Print all values from the n-Th row (Excluding table header)")
    public void Test5(int index){
        // if index = 1, then its a first row
        // if we dont specify  td index, it will take all td elements
        // in css we use space " ", in xpath // to get any child
        // css selector alternative: table[@id='table1'] tbdoy tr:nth-of-type(2) td
        // if index exceeds table size, you will not get any errors, list will be just empty
        // findElements() doesn't give NoSuchElementException , in any case
        List<WebElement> nThRow = driver.findElements(By.xpath("//*[@id=\"table1\"]/tbody/tr["+index+"]/td"));
        for (WebElement each : nThRow){
             System.out.println(each.getText());
            }
    }

    @Test(description = "Verify that email in the third row is equals to ''jdoe@hotmail.com' " )
    public void Test6(){
        int row = 3; //represents row number
        int column = 3;//represents column number
        //combination of tr and td index will give us specific cell value
        WebElement cell = driver.findElement(By.xpath("//table[@id='table1']//tbody//tr["+row+"]//td["+column+"]"));
        String expectedEmail = "jdoe@hotmail.com";
        String actualEmail = cell.getText();
        Assert.assertEquals(actualEmail, expectedEmail);
    }

    /*
    * Get all values from email column and verify that every value contains "@"
    * if no - fail test.
    *
     */

    @Test(description = "Verify that every email contain '@' ")
    public void Test7(){
        List<WebElement> eMails = driver.findElements(By.xpath("//*[@id=\"table1\"]/tbody/tr/td[3]"));
        for (WebElement each : eMails){
            Assert.assertTrue(each.getText().contains("@"));
        }
    }

    @Test(description = "Verify that after click on last name, values will be sorted in alphabetic order")
    public void Test8(){
        WebElement lastNameButton = driver.findElement(By.xpath("//*[@id=\"table1\"]/thead//tr//th[1]"));
        List<WebElement> LastNames = driver.findElements(By.xpath("//*[@id=\"table1\"]//tbody//td[1]"));
        for (int i=0; i<LastNames.size(); i++){
            String actualLastName = LastNames.get(i).getText();
            String followingLastName = LastNames.get(i+1).getText();
            Assert.assertTrue(actualLastName.compareTo(followingLastName)<0);
        }
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
