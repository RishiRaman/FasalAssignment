package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.Utilities;

public class WomenCategoryPage {

    @FindBy(id = "uniform-layered_category_4" )
    static WebElement topsCategoryCheckbox;

    @FindBy(id = "layered_id_attribute_group_1")
    static WebElement smallSizeCheckbox;

    @FindBy (id = "layered_id_feature_5")
    static WebElement compositionsCottonCheckbox;

    @FindBy(xpath = "//img[@title='Blouse']")
    static WebElement TwentySevenDollarProductLink;

    @FindBy(xpath = "//a[@title='Add to cart' and @data-id-product='2']")
    static WebElement addToCartButton;

    @FindBy(xpath = "//span[@title='Close window']")
    static WebElement closePopupButton;

    @FindBy(id = "color_8")
    static WebElement whiteColorBox;

    public void selectTopsCategory(){
        Utilities.waitTillElement( topsCategoryCheckbox, EnvironmentSetup.driver);
        topsCategoryCheckbox.click();
    }

    public void selectSmallSizeCategory(){
        Utilities.waitTillElement( smallSizeCheckbox, EnvironmentSetup.driver);
        smallSizeCheckbox.click();
    }

    public void selectCompositionsCategory(){
        Utilities.waitTillElement(compositionsCottonCheckbox, EnvironmentSetup.driver);
        compositionsCottonCheckbox.click();
    }

    public void mouseHoverToAddToCart(){
        Utilities.scrollDown(EnvironmentSetup.driver);
        Utilities.mouseHover(TwentySevenDollarProductLink, EnvironmentSetup.driver);
    }

    public void clickAddToCartBtn(){
        Utilities.javascriptClickButton(addToCartButton, EnvironmentSetup.driver);
    }

    public void closePopupWindow(){
        Utilities.waitTillElement(closePopupButton, EnvironmentSetup.driver);
        closePopupButton.click();
    }

    public void changesColorOfProduct(){
        Utilities.waitTillElement(whiteColorBox, EnvironmentSetup.driver);
        Utilities.javascriptClickButton(whiteColorBox, EnvironmentSetup.driver);
    }

}
