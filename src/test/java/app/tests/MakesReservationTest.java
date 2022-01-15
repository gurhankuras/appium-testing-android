package app.tests;

import app.driver.DriverWrapper;
import app.pageobjects.MainPageObject;
import app.pageobjects.ReservationFormPageObject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

    @When("I filled the form with correct info")
    public void iFilledTheFormWithCorrectInfo() {
        page.fillContactSection()
                .fillResidentSection();
    }

    @And("^I submit form f$")
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
}
