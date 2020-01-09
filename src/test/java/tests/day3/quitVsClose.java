package tests.day3;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class quitVsClose {

        /*
        Finally something happens when I click run,This is how people describe selenium on the first class.

        Our very first and very important method:
            .get("URL") ==> to open a website
         at the end, we have to close browser.
         for this ===> .close()  method.

         Also, we have .quit()  method.

         //// INTERVIEW QUESTION

         // What is the difference between close() and quit()  ??




         */
        public static void main(String[] args) throws InterruptedException {

            WebDriverManager.chromedriver().setup();
            ChromeDriver driver = new ChromeDriver();
            driver.get("http://practice.cybertekschool.com/open_new_tab");
            Thread.sleep(4000);  // will pause the program for 4 seconds
            /*
            Sleep method throws checked exception, that you will
            */

            driver.close(); // will close the tab only

            driver.quit(); // will close the entire browser




        }

    }

