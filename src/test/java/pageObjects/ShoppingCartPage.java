package pageObjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Utilities;

public class ShoppingCartPage {

    @FindBy(xpath = "//a[@title='Log in to your customer account']")
    static WebElement signInLink;

    @FindBy(id = "email")
    static WebElement emailAddressEditBox;

    @FindBy(id = "passwd")
    static WebElement passwordEditBox;

    @FindBy(id = "SubmitLogin")
    static WebElement signInButton;

    public void clickSignInLink(){
        Utilities.waitTillElement(signInLink, EnvironmentSetup.driver);
        signInLink.click();
    }

    public void enterLoginDetails(String username, String password){
        Utilities.waitTillElement(emailAddressEditBox, EnvironmentSetup.driver);
        emailAddressEditBox.sendKeys(username);
        Utilities.waitTillElement(passwordEditBox, EnvironmentSetup.driver);
        passwordEditBox.sendKeys(password);
        Utilities.waitTillElement(signInButton, EnvironmentSetup.driver);
        signInButton.click();
    }

}
