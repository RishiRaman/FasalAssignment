package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.*;

public class VerifyWebUIStepDef {

    EnvironmentSetup environmentSetup = new EnvironmentSetup();
    HomePage homePage = new HomePage();
    WomenCategoryPage womenCategoryPage = new WomenCategoryPage();
    TwentySevenDollarProductPage twentySevenDollarProductPage = new TwentySevenDollarProductPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    MyAccountPage myAccountPage = new MyAccountPage();

    @Given("Launch the browser")
    public void launchTheBrowser() {
        environmentSetup.launchURL();
    }

    @And("the application is launched successfully")
    public void verifyTheLaunchedApp() {
        Assert.assertEquals(homePage.getTitleHomePage(), "My Store");
    }

    @Given("the user clicks on Women category link")
    public void clickWomenCategoryLink() {
        homePage.clickWomenCategoryLink();
    }

    @And("the user clicks on the three filters")
    public void clicksOnTheThreeFilters() {
        womenCategoryPage.selectTopsCategory();
        womenCategoryPage.selectSmallSizeCategory();
        womenCategoryPage.selectCompositionsCategory();
    }

    @Then("the user clicks on Add to cart product with Twenty Seven Dollar value")
    public void clicks27$Product() {
        womenCategoryPage.mouseHoverToAddToCart();
        womenCategoryPage.clickAddToCartBtn();
        womenCategoryPage.closePopupWindow();
    }

    @And("the user changes color of the selected Twenty Seven Dollar value product")
    public void changesColorOfProduct() {
        womenCategoryPage.changesColorOfProduct();
    }

    @And("the user goes to Product page and changes the size to Medium from small size")
    public void changesSizeOfProduct() {
        twentySevenDollarProductPage.selectSizeFromDropdown();
    }

    @Then("the user clicks on Add to cart button")
    public void clickAddToCartBtn() {
        twentySevenDollarProductPage.clickAddToCartButton();
    }

    @And("the user proceeds to checkout the selected product")
    public void clickProceedToCheckoutButton() {
        twentySevenDollarProductPage.clickProceedToCheckoutButton();
    }

    @Then("the user clicks on Sign-In Link and enters username as {string} and Password as {string}")
    public void signIn(String username, String password) {
        shoppingCartPage.clickSignInLink( );
        shoppingCartPage.enterLoginDetails(username, password);
    }

    @Then("the user enters Shipping Details")
    public void enterShippingDetails() {
        shoppingCartPage.clickShoppingCartLink();
        shoppingCartPage.clickProceedToCheckoutLink();
        shoppingCartPage.clickProceedToCheckoutAddressButton();
        shoppingCartPage.selectTermsOFServiceCheckbox();
        shoppingCartPage.clickProceedToCheckoutCarrierButton();
    }

    @Then("the user verifies the shopping summary")
    public void verifyShoppingSummary() {
        myAccountPage.clickPayBankWireLink();
        Assert.assertEquals(myAccountPage.getShortSummaryText(),
                "You have chosen to pay by bank wire. Here is a short summary of your order:",
                "Validate the final order Summary ");
    }

    @And("the user verifies the shopping is complete")
    public void verifyOrderCompleteStatus() {
        myAccountPage.clickConfirmOrderButton();
        myAccountPage.getOrderCompleteText();
    }
}

