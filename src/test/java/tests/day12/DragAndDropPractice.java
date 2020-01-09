package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class DragAndDropPractice {

    @Test(description = "Drag and Drop Example")
    public void DragAndDrop(){
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        // accept cookies
        driver.findElement(By.cssSelector("button[title='Accept Cookies']")).click();

        Actions actions = new Actions(driver);
        // moon is draggable object (small ball)
        // eart is the target object (big ball )

        WebElement moon = driver.findElement(By.id("draggable"));
        WebElement earth = driver.findElement(By.id("droptarget"));
        BrowserUtils.wait(3);
        //
        actions.dragAndDrop(moon,earth).pause(200).build().perform();
        BrowserUtils.wait(3);
        driver.quit();
    }
}
