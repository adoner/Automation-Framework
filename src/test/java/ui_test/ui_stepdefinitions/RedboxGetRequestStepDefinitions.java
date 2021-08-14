package ui_test.ui_stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.Driver;

import java.util.List;
import java.util.Map;
import java.util.Random;

import static io.restassured.RestAssured.given;

public class RedboxGetRequestStepDefinitions {

    Response response;
    List<Map<String, Object>> deserializedList;
    WebDriver driver= Driver.driver();

    @When("User runs get request")
    public void user_runs_get_request() {
        response = given().accept(ContentType.JSON)
                .when().get("https://preprod.redbox.com/rbweb/api/product/js/__titles7")
                .then().extract().response();
    }

    @Then("Navigate to movie detail page and validate title name")
    public void Navigate_to_movie_detail_page_and_validate_title_name() throws InterruptedException {

        // convert json to java
        deserializedList = response.as(new TypeRef<List<Map<String, Object>>>() {});

        //Generate random number between given two values
        Random r = new Random();
        int low = 0;
        int high = deserializedList.size();
        int result = r.nextInt(high-low) + low;

        Map<String,Object> mapMovie = deserializedList.get(result);
        driver.get("https://www.redbox.com/"+mapMovie.get("url"));
        Thread.sleep(1000);//in order to load the element page title i need to put sleep thread here
        String pageTitle = driver.getTitle();
        String movieName = mapMovie.get("name").toString();

        Assert.assertTrue(pageTitle.contains(movieName));
    }
}
