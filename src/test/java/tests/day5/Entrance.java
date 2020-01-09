package tests.day5;

public class Entrance {

    /*
    How do we start automating?

        First, we need to open the page in the browser(chrome)
        Then, right click and inspect the page

        Click on the selector to select the specific element or text on the page
        We can click with a inspector on the specific element.
        Then, we can see HTML code that is behind this element
        Based on the properties/Attributes , tags and text we can choose locator strategy
        if its possible, use "id"
        in code , it will look like: <input type="text" id="first_name">

        WebElement firs_name = driver.findElement(By.id("first_name"));
        id must be unique!!
        Usually , we try to ask developers to add id's if its possible.

        The only case when we cannot use id, is when id is dynamic. Its basically
        when id is different for every refresh or once in a while.


     */




}
