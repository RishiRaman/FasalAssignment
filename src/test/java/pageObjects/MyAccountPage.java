package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Utilities;

public class MyAccountPage {

    @FindBy(linkText = "My addresses" )
    static WebElement MyAddressesLink;

    @FindBy(xpath = "//a[@title='Pay by bank wire']")
    static WebElement payBankWireLink;

    @FindBy(xpath = "//*[contains(text(),'You have chosen to pay by bank wire. Here is a short summary of your order:')]")
    static WebElement shortSummaryText;

    @FindBy(xpath = "//button[@type='submit']/span[text()='I confirm my order']")
    static WebElement confirmOrderButton;

    @FindBy(xpath = "//*[contains(text(),'Your order on My Store is complete.')]")
    static WebElement orderCompleteText;

    public void clickMyAddressesLink(){
        Utilities.waitTillElement(MyAddressesLink, EnvironmentSetup.driver);
        MyAddressesLink.click();
    }

    public void clickPayBankWireLink(){
        Utilities.waitTillElement(payBankWireLink, EnvironmentSetup.driver);
        payBankWireLink.click();
    }

    public String getShortSummaryText(){
        Utilities.waitTillElement(shortSummaryText, EnvironmentSetup.driver);
        return shortSummaryText.getText().trim();
    }

    public void clickConfirmOrderButton(){
        Utilities.waitTillElement(confirmOrderButton, EnvironmentSetup.driver);
        confirmOrderButton.click();
    }
    public String getOrderCompleteText(){
        Utilities.waitTillElement(orderCompleteText, EnvironmentSetup.driver);
        return orderCompleteText.getText().trim();
    }
}
