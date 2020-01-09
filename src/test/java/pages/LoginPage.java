package pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

// according to
public class LoginPage extends BasePage{

    @FindBy(id = "prependedInput") // this line will initialize Web element
    public WebElement userNameInput;

    @FindBy(id = "prependedInput2") // without FindBy, Web element will be null
    public WebElement passwordInput;

    @FindBy(id = "_submit")
    public WebElement loginButton;

    @FindBy(css = "[class='alert alert-error']")
    public WebElement warningMessage;

    public LoginPage(){
        // it's mandatory if we want to use @FindBy annotation
        // this means LoginPage class, Driver().get return WebDriver object
        PageFactory.initElements(Driver.get(),this);
}

    /**
     * reusable login method
     * just call this method to login
     * provide username and password as parameters
     * @param userName
     * @param password
     */
    public void login(String userName, String password){
        userNameInput.sendKeys(userName);
        // Keys.ENTER to replace login click
        passwordInput.sendKeys(password,Keys.ENTER);
    }

}
/*
    // According to page object model design, we have to create correspond page class
    // for each page of app, login page = login page class
    // every page class will store WebElements and methods to th

    @FindBy(id = "prependedInput") // this line will initialize Web Element
    public WebElement userInput;

    @FindBy(id="prependedInput2") // initialize Password WebElement to the passWordInput
    public WebElement passWordInput; // without @FindBy , WebElement will be null

    @FindBy(id = "_submit")
    public WebElement loginButton;

    @FindBy(css = "[class='alert alert-error']")
    public WebElement warningMessage;



    public LoginPage(){
        // its required if we want to use @FindBy annotation
        // this means LogInPage class
        // Driver.get() ==> returns WebDriver object
        PageFactory.initElements(Driver.get(), this);

//        userInput = Driver.get().findElement(By.id(""));
        // instead of doing this, we used @FindBy annotation above.
    }

    /**
     * reusable login method
     * just call this method to login
     * provide username and password as parameters
     * @param userName
     * @param password
     */
/*
    public void login(String userName, String password){
        userInput.sendKeys(userName);
        //Keys.ENTER to replace login click
        passWordInput.sendKeys(password, Keys.ENTER);
    }
    */


