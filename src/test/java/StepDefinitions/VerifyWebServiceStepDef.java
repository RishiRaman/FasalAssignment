package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import utilities.Utilities;

public class VerifyWebServiceStepDef {

    private static Response response;
    private static String baseURI = "https://reqres.in";

    @Given("the POST call is done to REGISTER-SUCCESSFUL Api and response is validated Successfully")
    public void registerSuccessfulPOSTCall(){
        RestAssured.baseURI = baseURI + "/api/register";
        String requestBody = Utilities.formRequestBody("email","eve.holt@reqres.in",
                "password","pistol");

        // Request is sent
        response =  RestAssured.given().header("Content-Type","application/json")
                .body(requestBody).when().post(RestAssured.baseURI);

        // Validate the Response Status code and Response body
        Assert.assertEquals(response.statusCode(), 200,
                "Validate REGISTER-SUCCESSFUL status code is appropriate.");
        Assert.assertEquals(JsonPath.from(response.getBody().asString()).get("id"),
                Integer.valueOf("4"),"Validate the id in response body is appropriate");
        Assert.assertEquals(JsonPath.from(response.getBody().asString()).get("token"),
                "QpwL5tke4Pnpja7X4","Validate the token in response body is appropriate");
    }

    @And("the POST call is done to CREATE Api and response is validated Successfully")
    public void createPOSTCall() {
        RestAssured.baseURI = baseURI + "/api/users";
        String requestBody = Utilities.formRequestBody("name", "morpheus",
                    "job","leader");
        response =  RestAssured.given().header("Content-Type","application/json")
                .body(requestBody).when().post(RestAssured.baseURI);

        // Validate the Response Status code and Response body
        Assert.assertEquals(response.statusCode(), 201,
                "Validate CREATE POST call status code is appropriate.");
        Assert.assertEquals(JsonPath.from(response.getBody().asString()).get("name"),
                "morpheus","Validate name in response body is appropriate");
        Assert.assertEquals(JsonPath.from(response.getBody().asString()).get("job"),
                "leader","Validate the job in response body is appropriate");

    }

    @When("the GET call is done to fetch the SINGE USER and response is validated Successfully")
    public void singleUserGETCall() {
        RestAssured.baseURI = baseURI + "/api/users/2";
        response = RestAssured.given().header("Content-Type","application/json").
                when().get(RestAssured.baseURI);

        // Validate the Response Status code and Response body
        Assert.assertEquals(response.statusCode(), 200,
                "Validate SINGLE USER GET call status code is appropriate.");
        Assert.assertEquals(Utilities.singleUserExpectedResponseBody(), response.getBody().asString(),
                "Validate the SINGLE USER GET call response body is appropriate.");

    }

    @And("the GET call is done to fetch LIST of USERS and response is validated Successfully")
    public void listUsersGETCall() {
        RestAssured.baseURI = baseURI + "/api/users";
        response = RestAssured.given().header("Content-Type","application/json").
                queryParam("page","2").when().get(RestAssured.baseURI);

        // Validate the Response Status code and Response body
        Assert.assertEquals(response.statusCode(), 200,
                "Validate SINGLE USER GET call status code is appropriate.");
        Assert.assertEquals(Utilities.listUsersExpectedResponseBody(), response.getBody().asString(),
                "Validate the SINGLE USER GET call response body is appropriate.");
    }

    @Then("the PUT call is done to modify user and response is validated Successfully")
    public void UPDATEUserPUTCall() {
        RestAssured.baseURI = baseURI + "/api/users/2";
        String requestBody = Utilities.formRequestBody("name", "morpheus",
                "job","zion resident");

        response = RestAssured.given().header("Content-Type","application/json").body(requestBody)
                .when().put(RestAssured.baseURI);

        // Validate the Response Status code and Response body
        Assert.assertEquals(response.statusCode(), 200,
                "Validate SINGLE USER GET call status code is appropriate.");
        Assert.assertEquals(JsonPath.from(response.getBody().asString()).get("name"),
                "morpheus","Validate name in response body is appropriate");
        Assert.assertEquals(JsonPath.from(response.getBody().asString()).get("job"),
                "zion resident","Validate the job in response body is appropriate");
    }

    @Then("the DELETE call is done and response is validated Successfully")
    public void DELETEUserCall() {
        RestAssured.baseURI = baseURI + "/api/users/2";
        String requestBody = Utilities.formRequestBody("name", "morpheus",
                "job","zion resident");

        response = RestAssured.given().header("Content-Type","application/json")
                .when().delete(RestAssured.baseURI);
        // Validate the Response Status code
        Assert.assertEquals(response.statusCode(), 204,
                "Validate DELETE user call status code is appropriate.");
    }
}

