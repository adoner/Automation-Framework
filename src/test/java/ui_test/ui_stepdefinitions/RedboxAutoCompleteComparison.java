package ui_test.ui_stepdefinitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.Driver;

import java.util.List;

public class RedboxAutoCompleteComparison {

    WebDriver driver = Driver.driver();

    @Then("Compare auto complete result vs results on the search results page")
    public void compare_auto_complete_result_vs_results_on_the_search_results_page() {

        WebElement searchBox = driver.findElement(By.name("search_term_string"));
        searchBox.sendKeys("Avengers");
        new Actions(driver).moveToElement(searchBox).click().perform();
        WebElement resultUltag = driver.findElement(By.xpath("//ul[@id='searchinput-results']"));
        List<WebElement> autoCompleteList = resultUltag.findElements(By.tagName("li"));

        WebElement exploreButton = driver.findElement(By.xpath("//button[text()='Explore All Results']"));
        exploreButton.click();

        //Movie name on page and search text comparision
        List<WebElement> movieCards = driver.findElements(By.xpath("//div[@data-index]"));

        Assert.assertTrue(autoCompleteList.size()==movieCards.size());

    }
}
