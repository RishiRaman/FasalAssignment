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

    @FindBy (xpath = "//a[@title='View my shopping cart']")
    static WebElement viewShoppingCartLink;

    @FindBy (xpath = "//a[@class='button btn btn-default standard-checkout button-medium']")
    static WebElement proceedToCheckoutLink;

    @FindBy(name = "processAddress")
    static WebElement proceedToCheckoutAddressButton;

    @FindBy (id = "cgv")
    static WebElement termsOfServiceCheckbox;

    @FindBy(name = "processCarrier")
    static WebElement proceedToCheckoutCarrierButton;

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

    public void clickShoppingCartLink(){
        Utilities.waitTillElement(viewShoppingCartLink, EnvironmentSetup.driver);
        viewShoppingCartLink.click();
    }

    public void clickProceedToCheckoutLink(){
        Utilities.scrollDown(EnvironmentSetup.driver);
        Utilities.waitTillElement(proceedToCheckoutLink, EnvironmentSetup.driver);
        proceedToCheckoutLink.click();
    }

    public void clickProceedToCheckoutAddressButton(){
        Utilities.waitTillElement(proceedToCheckoutAddressButton, EnvironmentSetup.driver);
        proceedToCheckoutAddressButton.click();
    }

    public void selectTermsOFServiceCheckbox(){
        Utilities.waitTillElement(termsOfServiceCheckbox, EnvironmentSetup.driver);
        termsOfServiceCheckbox.click();

    }

    public void clickProceedToCheckoutCarrierButton(){
        Utilities.waitTillElement(proceedToCheckoutCarrierButton, EnvironmentSetup.driver);
        proceedToCheckoutCarrierButton.click();
    }

}
