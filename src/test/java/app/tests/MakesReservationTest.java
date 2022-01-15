package app.tests;

import app.driver.DriverWrapper;
import app.pageobjects.MainPageObject;
import app.pageobjects.ReservationFormPageObject;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.net.MalformedURLException;

public class MakesReservationTest {
    private ReservationFormPageObject page;
    private MainPageObject mainPageObject;

    @Given("I want to book")
    public void iWantToBook() throws MalformedURLException {
        DriverWrapper.init();
       var homePage = new MainPageObject(DriverWrapper.getDriver());
       page = homePage.navigatesToAvailableHotels().showHotelDetails().showReservationForm();
    }

    @And("I am shown reservation form")
    public void iAmShownReservationForm() {
        Assert.assertTrue(page.isTitleShown());
    }

    @When("I fill in the form with valid data")
    public void iFilledTheFormWithCorrectInfo() {
        page.fillContactSection()
                .fillResidentSection();
    }

    @And("^I submit reservation form$")
    public void iSubmitFormF() {
        mainPageObject = page.submitForm();
    }

    @Then("I am shown home page")
    public void iAmShownHomePage() {
        Assert.assertTrue(mainPageObject.isTitleShown());
    }

    @When("I want to make a request")
    public void iWantToMakeARequest() {
        page.selectMakeRequest();
    }

    @Then("I should see request text field")
    public void iShouldSeeRequestTextField() {
        Assert.assertTrue(page.isMakeRequestTextFieldVisible());
    }

    @But("^I fill in (\\w*) with (.*)$")
    public void iFillInFieldWithValue(String fieldName, String value) {
        page.fillByFieldName(fieldName, value);
    }

    @Then("I should be shown error")
    public void iShouldBeShownError() {
    }
}
