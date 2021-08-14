package ui_test.ui_stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Driver;

public class RedboxMovieSearch {

    WebDriver driver= Driver.driver();

    @When("Navigate to search page")
    public void navigate_to_search_page() {
        driver.get("https://www.redbox.com");
    }

    @Then("Search movie name and validate title name on movie detail page")
    public void search_movie_name_and_validate_title_name_on_movie_detail_page() throws InterruptedException {

        WebElement searchBox = driver.findElement(By.name("search_term_string"));
        WebElement submitButton = driver.findElement(By.xpath("//button[@value='search']"));
        searchBox.sendKeys("Wonder Woman 1984");
        submitButton.click();
        Thread.sleep(1000);
        WebElement movieLink = driver.findElement(By.xpath("//a[@aria-label='Wonder Woman 1984']"));
        movieLink.click();
        Thread.sleep(1000);

        //Page title and search text comparision
//        String pageTitle = driver.getTitle();
//        String searchText = "Wonder Woman 1984";
//        Assert.assertTrue(pageTitle.contains(searchText));

        //Movie name on page and search text comparision
        WebElement nameOnPage = driver.findElement(By.xpath("//h1[@data-test-id='title_detail-name']"));
        String actualMovieName = nameOnPage.getText();
        String expectedMovieName = "Wonder Woman 1984";
        Assert.assertEquals(expectedMovieName, actualMovieName);

    }
}
