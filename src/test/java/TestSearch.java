//TestSearch
import PageObjects.HeaderPage;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class TestSearch extends BaseClass{



    @Description("Validate search functionality")
    @Test(description = "Test Search with criteria returning values.")
    @Parameters({"searchCriteria", "expectedResult"})
    public void Validate_Search(@Optional("macbook") String searchCriteria, @Optional("3") String expectedResult){
        HeaderPage headerPage = new HeaderPage(driver);
        int results = Integer.parseInt(expectedResult);
        headerPage.SearchInput(searchCriteria);
        int SearchResults1 = headerPage.getSearchResults();
        Assert.assertTrue(driver.getCurrentUrl().contains("search="+searchCriteria));

        // Assert.assertEquals(results.size(), expectedResult,
        //        String.format("Expecting %s results, but got %s", expectedResult, results.size()));

        Assert.assertEquals(SearchResults1, results,
                "Expecting " + expectedResult + " results, but got " + SearchResults1);
    }

    @Description("Validate search functionality")
    @Test(description = "Test Search with criteria NOT returning values.")
    public void Test_Empty_Results(){
        String searchCriteria = "Star Wars";
        int expectedResult = 0;
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.SearchInput(searchCriteria);

        //Assert.assertTrue(driver.getCurrentUrl().contains("search="+searchCriteria));

        //Assert.assertEquals(results.size(), expectedResult,
        //        String.format("Expecting %s results, but got %s", expectedResult, results.size()));

        int SearchResults2 = headerPage.getSearchResults();
        Assert.assertEquals(SearchResults2, expectedResult,
                "Expecting " + expectedResult + " results, but got " + SearchResults2);


    }
}