package ui_test.ui_stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.Driver;

import java.util.List;

public class RedboxSearchComparison {

    WebDriver driver = Driver.driver();

    @When("Go to search page")
    public void go_to_search_page() {
      driver.get("https://www.redbox.com");
    }

    @Then("Search movie name and validate search text on search result page")
    public void search_movie_name_and_validate_search_text_on_search_result_page() throws InterruptedException {

        WebElement searchBox = driver.findElement(By.name("search_term_string"));
        searchBox.sendKeys("Avengers");
        new Actions(driver).moveToElement(searchBox).click().perform();
        WebElement exploreButton = driver.findElement(By.xpath("//button[text()='Explore All Results']"));
        exploreButton.click();

        //Movie name on page and search text comparision
        List<WebElement> movieCards = driver.findElements(By.xpath("//div[@data-index]"));
        String searchText = "Avengers";

        for(WebElement element : movieCards){

            WebElement linkElement = element.findElement(By.tagName("a"));
            String linkText = linkElement.getAttribute("aria-label");
            Assert.assertTrue(linkText.contains(searchText));
        }
    }
}
