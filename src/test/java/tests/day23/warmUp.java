package tests.day23;

public class warmUp {
    /*
    Agenda:
        BDD (Behavior Driven Development)
        CUCUMBER as BDD tool
        TDD (Test Driven Development)

    Starting from today, we will work on new project.

    New frameWork will be based on Cucumber + Selenium + Junit

    ########################################################################

    Our current framework is combination of:

    Data Driven Framework + Page Object Model frameWork

    it's also called hybrid.

    When we create corresponded page classes for all pages of application, we call it Page Object Model( design pattern)
    Since we implement this design into our framework, our framework becomes Page Object Model framework.

    On top of that, we store test data not in java classes ( like String variables) we keep it outside,
    for example in excel files, csv, json
    or any other files.

    In our framework, we use excel files for storing test data. To read that data we use apache poi.

    There are also other frameworks that we didn't talk about yet.
    Another type of framework is a Keyword Driven FrameWork:

    The idea is to store test steps and actions in external file. For example excel:

        TEST_001
        Open "google.com"
        verify title "Google"
        "Enter java book"
        "click on search"
        Verify that search item is displayed

        By changing keywords, we are changing test flow. In case of DDT we are changing test data only.

        ####################################################

        Module based Framework

        It's like PAge Object Model, but more for tests. We are breaking down ( group) tests based on module names.

        tests
            Fleet
                VehicleTests.java
                VehicleCosts.java
            Customers
                AccountsTests.java
                ContactsTests.java

        Best thing is to combine Modular + Page Object + Data Driven

        #######################################################

        BDD - Behavior Driven Development

        In bDD we write business requirements from end user perspective.

        As a user , I want to be able to ...............

        This is a template for agile stories

        ####################3

        Test#1

        String word = "apple";
        String expectedResult = "elppa";
        String actualResult = reverseString(word);

        Assert.assertEquals("elppa", "apple");   // must be true

        public String reverseString(String str){

            **
            * code that will reverse string
            *
            return reversed;
        }

        Test Driven Development --> it's a development approach when before starting actual development, we create tests
        that will verify functionality ( method ). Functionality will be over unit test.
        For unit test we can use TestNG or Junit. Both of them are unit testing frameworks.

        Junit is pure testing framework.

        For example in repl.it almost all assignments use Junit for verification.
        Usually developers write unit tests for their code.

        Unit testing is the lowest, and essential stage of development as well as code review

        Sometimes SDET also involve into unit testing.
        But our focus is on functional testing with selenium WebDriver.

        We were doing TDD whenever we were working on repl.it tasks, Every solution had to go through bunch of unit tests.
        Based on errors, we could understand how to fix our code.

        ##############################################
        BDD is a branch of TDD.
        For implementing SDD

   BDD ( Behavior Driven Development )

        in simple words, it's when we write human readable business requirements.

        For any new feature that has to be developed, we create user story and user story has some template:
           As a user, I want to be able to........

        Every story has acceptance criteria.
        Entire team participate sprint planning meetings to discuss stories for next sprint.

        Since everyone us looking into same requirements, there is gonna be less confusion during testing and development.

        In our project , PO was providing business requirements, then these requirements where written into use story
        with acceptance criteria. PO explains what feature team has to develop and how this feature should work.

        Based on user story we create feature files to create tests.

        To implement BDD into our framework we use Cucumber.

        * Cucumber allows to write test scenarios from end-user perspective.
        * Cucumber allows to make test scenarios understandable for non-technical people
        * Cucumber use special language that calls gherkin.

        gherkin is not a programming language, it's a collection of keywords that are used to write scenarios:
        Given, When, Then, And, But, Scenario, Scenario Outline, Feature, Background

        As we remember, we were doing DDT with Testng through @DataProvider

        Cucumber, supports DDT with Scenario Outline.

        Feature:
            it's a gherkin keyword. After: you need to explain what feature will be tested here.

            Feature: Login
                As user, I want to be able to log into vytrack under
                different roles with username and password


            #####################################33

            Steps to write tests with cucumber:

            1. Create feature file and write test scenarios.
            2. Go to CucumberRunner class and execute dryRun.
                make sure you sepecified:
                glue = "com/vytrack/step_definitions"
                features = "src/test/resources/features"
            3. implement step definitions and delete original content from step definitions.
            4. Once you provided code, change dryRun to false and run tests indeed


            With testng we were creating methods with @Test annotation.
            in cucumber, we create scenarios, and then every scenario has code implementation in step definition class

            Also, if we remember we had TestBase class with @BeforeMethod and @AfterMethod annotated methods.

            ###########################################

            @BeforeMethod - runs before every test, setuo
            @AfterMethod - runs after every test, cleanup
            #############################################

            In cucumber, we can do same thing. It calls hook.

            hook runs before every scenario and after every scenario.

            ###########################################

            How to create hook?

            We can put it into any step definition class, but better to put it under step_definitions package into
            separate class called Hook.

            Hook will be executed before and after test execution.

            @Before will be executed

            Given user is on the login page
            Then user logs in as driver
            And user verifies that "Dashboard" page subtitle is displayed

            @After will be executed


            #####################################3
            Scenario object returns info about current scenario.
            By using this class, Scenario, we can check test status: passed/failed

            failure will be followed by stack trace (error description )

            ##########################################

            With tags we can run specific scenarios and ignore others:

            Mark and scenario with annotation and use "tags" in runner class, this line indicates that tests with given
            annotations will be executed and others will be ignored.

            tags = "@negative_test"       // runs tests only with this tag
            tags = "not @negative_test"     // runs tests only WITHOUT this tag
            tags = "~@negative_test"        // runs tests only WITHOUT this tag (old way)

            You can create any tag name. For example based on modules, type of test, like @smoke, @regression,
            user story number @VYT-1234

            dryRun = true   ==> we don't run tests, just checking if everything ready for testing
            dryRun = false   ==> runs tests

            We can specify the annotations.

            tags ="@store_manager or @driver"       ===> it will execute the annotations that matches either one.

            tags = "@store_manager and @driver"   ===> tag must match both annotations to be executed.


        ##########################################
        To generate default cucumber report, add this line into your runner class

        plugin = {"html:target/default-cucumber-reports"}

        Every time, cucumber will generate default html report


        #############################################3

        Background :
            it's a precondition for every test scenario in one particular feature file. Instead of repeating same test
            steps for every scenario, we can put these steps into background.

        Flow of execution:
            hook before ==> background ==> scenario  ==> hook after

        hook and background are completely




        ###################################3

        Agenda:
            Cucumber data tables. Today we will learn how to extend test step and fit data table into test steps.




     */
}
