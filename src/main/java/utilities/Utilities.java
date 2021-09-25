package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities {

    public static void waitTillElement(WebElement element, WebDriver driver){
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOf(element));
        }catch (Exception e){}
    }

    public static void mouseHover(WebElement element, WebDriver driver){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public static void scrollDown(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,850)", "");

    }

    public static void javascriptClickButton(WebElement element, WebDriver driver){
        try{
            Thread.sleep(3000);
        }catch (Exception e){}
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }
}
