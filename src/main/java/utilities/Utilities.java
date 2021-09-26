package utilities;

import com.google.gson.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.HashMap;
import java.util.Map;

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

    public static String formRequestBody(String keyOne, String ValueOne, String keyTwo, String ValueTwo){
        Map<String, String> requestBodyMap =  new HashMap<String, String>();
        requestBodyMap.put(keyOne,ValueOne);
        requestBodyMap.put(keyTwo,ValueTwo);
        // Convert Map to JSON
        Gson gson = new Gson();
        String requestBody = gson.toJson(requestBodyMap);

        return requestBody;
    }

    public static String singleUserExpectedResponseBody(){
        String singleUserExpectedResponse = "{\"data\":{\"id\":2,\"email\":\"janet.weaver@reqres.in\",\"first_name\":\"Janet\",\"last_name\":\"Weaver\",\"avatar\":\"https://reqres.in/img/faces/2-image.jpg\"},\"support\":{\"url\":\"https://reqres.in/#support-heading\",\"text\":\"To keep ReqRes free, contributions towards server costs are appreciated!\"}}";
        JsonObject singleUserExpectedResponseJsonObject = new Gson().fromJson(singleUserExpectedResponse, JsonObject.class);

        return singleUserExpectedResponseJsonObject.toString();
    }

    public static String listUsersExpectedResponseBody(){
        String listUserExpectedResponse = "{\"page\":2,\"per_page\":6,\"total\":12,\"total_pages\":2,\"data\":[{\"id\":7,\"email\":\"michael.lawson@reqres.in\",\"first_name\":\"Michael\",\"last_name\":\"Lawson\",\"avatar\":\"https://reqres.in/img/faces/7-image.jpg\"},{\"id\":8,\"email\":\"lindsay.ferguson@reqres.in\",\"first_name\":\"Lindsay\",\"last_name\":\"Ferguson\",\"avatar\":\"https://reqres.in/img/faces/8-image.jpg\"},{\"id\":9,\"email\":\"tobias.funke@reqres.in\",\"first_name\":\"Tobias\",\"last_name\":\"Funke\",\"avatar\":\"https://reqres.in/img/faces/9-image.jpg\"},{\"id\":10,\"email\":\"byron.fields@reqres.in\",\"first_name\":\"Byron\",\"last_name\":\"Fields\",\"avatar\":\"https://reqres.in/img/faces/10-image.jpg\"},{\"id\":11,\"email\":\"george.edwards@reqres.in\",\"first_name\":\"George\",\"last_name\":\"Edwards\",\"avatar\":\"https://reqres.in/img/faces/11-image.jpg\"},{\"id\":12,\"email\":\"rachel.howell@reqres.in\",\"first_name\":\"Rachel\",\"last_name\":\"Howell\",\"avatar\":\"https://reqres.in/img/faces/12-image.jpg\"}],\"support\":{\"url\":\"https://reqres.in/#support-heading\",\"text\":\"To keep ReqRes free, contributions towards server costs are appreciated!\"}}";
        JsonObject listUserExpectedResponseJsonObject = new Gson().fromJson(listUserExpectedResponse,JsonObject.class);

        return listUserExpectedResponseJsonObject.toString();
    }
}
