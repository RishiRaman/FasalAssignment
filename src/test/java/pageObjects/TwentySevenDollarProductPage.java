package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utilities.Utilities;

public class TwentySevenDollarProductPage {

    @FindBy(id = "group_1")
    static WebElement sizeDropdownElement;

    @FindBy(name = "Submit")
    static WebElement addToCartButton;

    @FindBy (xpath = "//a[@title='Proceed to checkout']")
    static WebElement proceedToCheckoutButton;



    public void selectSizeFromDropdown(){
        //Utilities.waitTillElement(sizeDropdownElement, EnvironmentSetup.driver);
        Select sizeDropdownBox = new Select(sizeDropdownElement);
        sizeDropdownBox.selectByVisibleText("M");
    }

    public void clickAddToCartButton(){
        Utilities.waitTillElement(addToCartButton, EnvironmentSetup.driver);
        addToCartButton.click();
    }

    public void clickProceedToCheckoutButton(){
        Utilities.waitTillElement(proceedToCheckoutButton, EnvironmentSetup.driver);
        proceedToCheckoutButton.click();
    }




}
