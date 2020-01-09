package tests.day20_ddtWithExcel;

public class WarmUp {

    /*
    Apache POI it's a java library that helps to work with excel files.

    *** Why it's important to know this library?

        Excel file is very popular way to store data. It can contain thousands of rows and columns with data.
        In order to retrieve and inject that data with java, we use Apache POI library.

     In testing, excel files are very common for storing test data.

     Excel file can be used as a source of test data in automation.

     ########################################################################################

     DDT data-driven testing is a software testing methodology. The idea is to retrieve test data from outside.
     We don't want to store test data in variables. Instead, we want to be able to change test data without affecting
     test script. When application requires testing with multiple data inputs we can use Data Driven framework.


     *** What does it mean " Test data hard coded " ?
     (Hard coded means that for example if we want to change our login credentials, we will have to go to out test
     scripts and change the code. But with Data Driven, we can change from Excel and call with the same test script.
     SO WE CAN KEEP OUR TEST SCRIPTS AND TEST DATA SEPARATELY !!!!!!!!!!!!)

        loginPage.login(excel.getUsername("storemanager85"), excel.getPassword("UserUser123"));

        Data driven testing - test data drives test

        Test and test data is different.
        Changes in test data shouldn't require changes in code.

        ### If file name is red, that means file is not staged in git.

        In TestNG we can run same test multiple times with @DataProvider. If we combine data provider with excel file,
        then we can run same test multiple times with data that is coming from excel file.

        If we see "?" on our excel file in intellij (vytrack_testusers.xlsx ),
         means that we don't have the excel app in our computer.



     */
}
