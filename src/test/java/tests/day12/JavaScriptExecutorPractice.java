package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class JavaScriptExecutorPractice {

    private WebDriver driver;

    @BeforeMethod
    public void SetUp(){
        driver = BrowserFactory.getDriver("Chrome");
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
    }

    @Test(description = "Verify that page is scrolling down")
    public void Test1() {
        JavascriptExecutor JavaS = (JavascriptExecutor) driver; // JavascriptExecuter is an interface so we have to cast it
        for (int i = 0; i < 10; i++) {
            JavaS.executeScript("window.scrollBy(0,500);");
            BrowserUtils.wait(1);
        }
    }

    @Test(description = "Scrolling down with specific element")
    public void test2(){
        driver.get("http://practice.cybertekschool.com/large");
        WebElement link = driver.findElement(By.linkText("Cybertek School"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // this script must scroll, until link element is not visible
        // once link element is visible, it will stop scrolling
        // arguments[0]  = means first WebElement after comma(link)
        // argument is an array of WebElements after comma
        js.executeScript("arguments[0].scrollIntoView(true)",link);

        BrowserUtils.wait(3);

    }

    @Test(description = "Click with JS executer")
    public void test3(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading");
        // Example 1 is a beginning of the phrase
        WebElement link1 = driver.findElement(By.partialLinkText("Example 1"));
        BrowserUtils.wait(2);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // arguments[0] = link1 WebElement
        // Whenever regular selenium methods are not working, use js executor
        // or for scrolling
        // arguments[0].click() = is an alternative for link1.click()
        js.executeScript("arguments[0].click();",link1);
        BrowserUtils.wait(2);


    }

    @Test(description = "Enter text with JS executor")
    public void test4(){
        driver.get("http://practice.cybertekschool.com/sign_up");
        WebElement name = driver.findElement(By.name("full_name"));
        WebElement email = driver.findElement(By.name("email"));
        WebElement submit = driver.findElement(By.name("wooden_spoon"));
        // to create jsExecutor we need to cast to Webdriver object
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value', 'Jon Smith')",name);
        BrowserUtils.wait(1);
        js.executeScript("arguments[0].setAttribute('value', 'someEmail@gmail.com')",email);
        BrowserUtils.wait(1);
        js.executeScript("arguments[0].click()",submit);
        BrowserUtils.wait(1);
    }



    @AfterMethod
    public void TearDown(){
        driver.quit();
    }
}
