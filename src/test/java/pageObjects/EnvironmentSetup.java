package pageObjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class EnvironmentSetup {

    public static WebDriver driver;
    HomePage homePage;
    WomenCategoryPage womenCategoryPage;
    TwentySevenDollarProductPage twentySevenDollarProductPage;
    ShoppingCartPage shoppingCartPage;
    MyAccountPage myAccountPage;

    public EnvironmentSetup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        homePage = new HomePage();
        PageFactory.initElements(driver, homePage);

        womenCategoryPage = new WomenCategoryPage();
        PageFactory.initElements(driver, womenCategoryPage);

        twentySevenDollarProductPage =  new TwentySevenDollarProductPage();
        PageFactory.initElements(driver,twentySevenDollarProductPage);

        shoppingCartPage = new ShoppingCartPage();
        PageFactory.initElements(driver, shoppingCartPage);

        myAccountPage = new MyAccountPage();
        PageFactory.initElements(driver, myAccountPage);

    }

    public void launchURL(){
        driver.get("http://automationpractice.com/index.php");
    }
}
