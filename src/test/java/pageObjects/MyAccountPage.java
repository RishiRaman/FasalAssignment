package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Utilities;

public class MyAccountPage {

    @FindBy(linkText = "My addresses" )
    static WebElement MyAddressesLink;

    public void clickMyAddressesLink(){
        Utilities.waitTillElement(MyAddressesLink, EnvironmentSetup.driver);
        MyAddressesLink.click();
    }


}
