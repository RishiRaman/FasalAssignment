package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Utilities;

public class HomePage {

    @FindBy(linkText = "Women" )
    static WebElement womenCategoryLink;

    public String getTitleHomePage(){
        return EnvironmentSetup.driver.getTitle();
    }

    public void clickWomenCategoryLink(){
        Utilities.waitTillElement( womenCategoryLink, EnvironmentSetup.driver);
        womenCategoryLink.click();
    }
}
