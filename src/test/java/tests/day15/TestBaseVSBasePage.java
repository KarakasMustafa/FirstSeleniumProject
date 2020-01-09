package tests.day15;

public class TestBaseVSBasePage {


    /*
    What is the difference between BasePage and TestBase??

    BasePage ==>
        Super class for page classes, all classes that are located under page packages
      EX:
        public class LoginPage extends BasePage{  }

    TestBase:
        super class for test cases, all classes that are located under test packages
      EX:
        public class LoginTests extends TestBase {   }

        The role of TestBase class is to Setup everything before tests( initialize WebDriver,
        provide browser configuration, connect to DataBase,initialize report) and clean up after test
        (close browser, disconnect to DataBase, flush report, take a screenshot if test failed)

        The role of BasePage class is to store common web elements and methods of application. Since page
        class is a WebElements repository, we can have parent class that will store common WebElements.
        Also, this class initialize PageFactory.

        The role of PageFactory is to provide easier way for finding elements ( to be able to use @FindBy annotation)

        Don't forget that we have Driver class that creates and provides WebDriver Object.
        1 WebDriver = 1 Browser

        To access WebDriver object, We need to call get() method from Driver class. This method is static
        because WebDriver object is also static and can be called without instantiating Driver Class

        When we have static WebDriver object , we ensure that everyone is sending commands to same browser

        Static methods/variables belong to class not to specific object.
        (The reason that we use static, we can call just through class name, we dont need to create class object and also
        we save memory, and its easier to manage)

        When the required WebElement objects needs to match at least one of the given criteria use @FindBys
        annotation.

        With TestNG framework we can use Extent report to generate nice and user friendly HTML report of test results.
        Since report is very important component of every test automation framework, we have to  make it look nice

        To setup Extent report:
            Step 1.
                If you

     */
}
