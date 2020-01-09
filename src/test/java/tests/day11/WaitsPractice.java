package tests.day11;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class WaitsPractice {

    private WebDriver driver;

    @BeforeMethod
    public void SetUp(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
    }

    @Test
    public void Test1(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Dynamic Loading")).click();
        driver.findElement(By.partialLinkText("Example 2")).click();  // We match only a part of linkText

        driver.findElement(By.tagName("button")).click();
        // this is for "Hello World! "
        WebElement finishElement = driver.findElement(By.id("finish"));
        System.out.println(finishElement.getText());
    }

    @Test
    public void Test2() throws InterruptedException {
        driver.findElement(By.linkText("Dynamic Loading")).click();  //
        driver.findElement(By.partialLinkText("Example 1")).click(); // Select Example 1 in Dynamic Loading
        driver.findElement(By.xpath("//button[text()=\"Start\"]")).click();   // click the start button
        WebDriverWait wait = new WebDriverWait(driver, 10);  // Explicit wait

        WebElement userNameInput = driver.findElement(By.id("username"));
        wait.until(ExpectedConditions.visibilityOf(userNameInput));
        userNameInput.sendKeys("tomsmith");

        WebElement PassWordInput = driver.findElement(By.id("pwd"));
        wait.until(ExpectedConditions.visibilityOf(PassWordInput));
        PassWordInput.sendKeys("SuperSecretPassword");

        WebElement submit = driver.findElement(By.cssSelector("button[type=\"submit\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(submit));
        submit.click();

        WebElement message = driver.findElement(By.tagName("h4"));
        String expectedMessage = "Welcome to the Secure Area. When you are done click logout below.";
        String actualMessage = message.getText();

        Assert.assertEquals(actualMessage,expectedMessage);
    }

    @Test
    public void Test3(){
        driver.findElement(By.linkText("Dynamic Loading")).click();  //
        driver.findElement(By.partialLinkText("Example 5")).click(); // Select Example 5 in Dynamic Loading
        WebDriverWait wait = new WebDriverWait(driver, 15);

        WebElement overlayScreen = driver.findElement(By.cssSelector("[class='fa fa-cog fa-spin']"));
        // wait until overlay screen disappear
        // otherwise, we will have issue to click or enter the text
        wait.until(ExpectedConditions.invisibilityOf(overlayScreen));

    }

    @Test(description = "Fluent wait example")
    public void Test4(){
        driver.findElement(By.linkText("Dynamic Loading")).click();
        driver.findElement(By.partialLinkText("Example 2")).click();
        Wait wait = new FluentWait(driver)
        .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(ElementNotVisibleException.class);
        WebElement message = (WebElement) wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("finish"));
            }
        });

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
