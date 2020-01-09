package tests.day16;

public class WarmUp {
    /*
    12/05/2019
    Agenda:
        Extent report with TestNG
        Taking a screenshot

        Afternoon:
            Git/github: conflicts, stashing changes
 =================================================================

    To avoid copy/pasting we implemented page Object Model: idea is to create corresponded java class for each page of application.
    Login page in vyTrack = LoginPage.java under pages package

    Another enhancement is TestBase.
    TestBase is a super class for all tests classes. It contains setup and tearDown steps/stages.
    Don't forget to extend TestBase class in every Test classes.


    WHAT IS DIFFERENCE BETWEEN TESTBASE AND BASEPAGE ???
       BasePage ===> super class for page classes, all classes that are located under pages package.
            public class LoginPage extends BasePage {

       TestBase ===> super class for test classes, all classes that are located under tests package
            public class LoginTests extends TestBase {

        The role of TestBase class is to set up everything before test ( initialize WebDriver, provide browser configuration, connect to database,
        initialize report ) and clean up after test ( close browser, close connection to DB, flush report, take a screenshot if test failed )

        The role of BasePage class is to store common Web elements and methods of application. Since page class is a WebElements repository,
        we can have parent class that will store common WebElements. Also, this class initialize PageFactory.

        The role of PageFactory is to provide easier way for finding elements ( @FindBy annotation )

        Don't forget that we have Driver class that creates and provides WebDriver object.
        1 WebDriver = 1 browser

        To access WebDriver object, we need to call get() method from Driver class. This method is static because WebDriver object is also static and can
        be called without instantiating Driver class.

        When we have static WebDriver object we ensure that everyone is sending commands to same browser.

        Static methods/variables belong to class not to specific object.

        Driver class is more advanced version of BrowserFactory class.

        When the required WebElement objects needs to match all of the given criteria use @FindBys annotation

        When required WebElement objects needs to match at least one of the given criteria






        To Extent report:
            Step 1. If your project is based on Maven, add dependency in pom.xml file:

               <dependency>
                  <groupId>com.aventstack</groupId>
                  <artifactId>extentreports</artifactId>
                  <version>4.0.9</version>
              </dependency>

            Step.2 We need to add couple things into

     */
}
