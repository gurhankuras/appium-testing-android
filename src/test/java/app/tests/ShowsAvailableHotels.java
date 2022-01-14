package app.tests;

import app.driver.DriverWrapper;
import app.pageobjects.HotelList;
import app.pageobjects.MainPageObject;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class ShowsAvailableHotels {
    public HotelList page;

    /*
    @Before()
    public void setUp() throws Exception {
        DriverWrapper.init();
    }
*/
    @Given("I am shown available hotels")
    public void iAmShownAvailableHotels() {
        page = new MainPageObject(DriverWrapper.getDriver()).navigatesToAvailableHotels();
    }


    @Then("I see all of the summary info")
    public void iSeeAllOfTheSummaryInfo() {
        Assert.assertTrue(page.hasAllSummaryInfo());
    }
}
