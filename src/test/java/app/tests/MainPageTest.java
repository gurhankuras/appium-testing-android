package app.tests;

import app.driver.DriverWrapper;
import app.exceptions.InvalidCheckInDateException;
import app.pageobjects.HotelList;
import app.pageobjects.MainPageObject;
import app.utils.TestHelper;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainPageTest {
    //public AndroidDriver<MobileElement> driver;
    public MainPageObject page;
    public HotelList hotelListPage;

    @Before()
    public void setUp() throws Exception {
        /*
        DesiredCapabilities capabilities = new DesiredCapabilities();
        // capabilities.setCapability("platformVersion", "11");
        capabilities.setCapability("deviceName", "sdk_gphone_arm64");
        capabilities.setCapability("udid", "emulator-5554");
        capabilities.setCapability("appPackage", "com.ealeynaelmas.firstandroidapp");
        capabilities.setCapability("appActivity", "com.ealeynaelmas.firstandroidapp.MainActivity");
        capabilities.setCapability("appActivity", "com.ealeynaelmas.firstandroidapp.MainActivity");
        capabilities.setCapability(  "appium:automationName", "UiAutomator2");

        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

         */
        DriverWrapper.init();
        page = new MainPageObject(DriverWrapper.getDriver());
    }

    /*
    @After()
    public void cleanup() {
        driver.quit();
    }
*/

    @Given("I am on Main page")
    public void iAmOnMainPage() {

    }

    @When("^I fill in city text field with (.*)$")
    public void iFillCityTextFieldWithCity(String city) {
       //driver.findElement(page.cityTextFieldLocator).sendKeys(city);
        page.fillCity(city);
    }

    @And("^I fill in check in date text field with (.*)$")
    public void iFillCheckInDateTextFieldWithCheckInDate(String checkInDateStr) {
        page.fillCheckIn(checkInDateStr);
    }

    @And("^I fill in check out date text field with (.*)$")
    public void iFillCheckOutDateTextFieldWithCheckOutDate(String checkOutDateStr) {
        page.fillCheckOut(checkOutDateStr);
    }

    @And("^I fill in number of person text field with (.*)$")
    public void iFillNumberOfPersonTextFieldWithNumberOfPerson(String numberOfPerson) {
        page.fillNumberOfPerson(numberOfPerson);
    }

    @And("^I fill in number of child text field with (.*)$")
    public void iFillNumberOfChildTextFieldWithNumberOfChild(String numberOfChild) {
        page.fillNumberOfChild(numberOfChild);
    }

    @And("^I click on search button expecting (success|failure)$")
    public void iClickSearchButton(String expectation) {
        if (expectation.equals("failure")) {
            page.searchAsExpectingError();
        }
        else {
            page.search();
        }
    }

    @Then("^I should see the (empty field|not found) warning$")
    public void iShouldWarningThatSaysThatIMustFillAllFields(String warningType) {
        String toastMessage = TestHelper.getToastText(DriverWrapper.getDriver());
        if (warningType.equals("empty field")) {
            Assert.assertEquals(toastMessage, MainPageObject.emptyFieldWarningText);
        } else {
            Assert.assertEquals(toastMessage, MainPageObject.notFoundWarningText);
        }
    }

    @And("I should see the same page I am on")
    public void iShouldSeeTheSamePageIAmOn() throws InterruptedException {
        Thread.sleep(2000);
        var actualTitleText = page.getTitleElement().getAttribute("text");
        Assert.assertEquals(MainPageObject.titleText, actualTitleText);
    }

    @Given("I want to make a reservation")
    public void iWantToMakeAReservation() {
        
    }


    @When("^I fill the form with the info matching a hotel$")
    public void iFillTheFormWithTheInfoMatchingAHotel() {
        page.loadFormData();
    }

    @And("^I submit form$")
    public void iSubmitForm() {
        hotelListPage = page.search();
    }

    @Then("^I should be shown available hotels as a list in a new page$")
    public void iShouldBeShownAvailableHotelsAsAListInANewPage() {
        Assert.assertTrue(hotelListPage.hasAnyMatchingHotel());
    }



    /*
    @When("I fill city text field with {string}")
    public void iFillCityTextFieldWithCity(String city) {
        page.fillCity(city);
    }

    @And("I fill check in date text field with {string}")
    public void iFillCheckInDateTextFieldWith(String checkInDateStr) throws ParseException, InvalidCheckInDateException {
        var dateFormatter = new SimpleDateFormat("dd/MM/yyyy");

        String todayStr = dateFormatter.format(Calendar.getInstance().getTime());
        var today = dateFormatter.parse(todayStr);
        var checkInDate = dateFormatter.parse(checkInDateStr);

        if (checkInDate.compareTo(today) < 0) {
            throw new InvalidCheckInDateException("Past check-in date entered");
        }

        page.fillCheckIn(checkInDateStr);
    }

    @And("I fill check out date text field with {string}")
    public void iFillCheckOutDateTextFieldWith(String checkOutDate) {
        page.fillCheckOut(checkOutDate);
    }

    @And("I fill number of person text field with {string}")
    public void iFillNumberOfPersonTextFieldWith(String numberOfPerson) {
        page.fillNumberOfPerson(numberOfPerson);
    }

    @And("I fill number of child text field with {string}")
    public void iFillNumberOfChildTextFieldWith(String numberOfChild) {
        page.fillNumberOfChild(numberOfChild);
    }

    @And("^I click search button expecting (success|failure)$")
    public void iClickSearchButton(String expectation) {
        if (expectation.equals("failure")) {
            page.searchAsExpectingError();
        }
        else {
            page.search();
        }
    }

    @Then("^I should see the (empty field|not found) warning$")
    public void iShouldWarningThatSaysThatIMustFillAllFields(String warningType) {
        String toastMessage = TestHelper.getToastText(driver);
        if (warningType.equals("empty field")) {
            Assert.assertEquals(toastMessage, page.getEmptyFieldWarning());
        } else {
            Assert.assertEquals(toastMessage, page.getNotFoundWarning());
        }
    }

    @And("I should see the same page I am on")
    public void iShouldSeeTheSamePageIAmOn() throws InterruptedException {
        Thread.sleep(2000);
        var actualTitleText = page.getTitleElement().getAttribute("text");
        Assert.assertEquals(page.getTitleText(), actualTitleText);
    }
    */


    /*
    @When("^I fill city text field with \"([^\"]*)\"$")
    public void iFillCityTextFieldWithCity(String city) {
        page.fillCity(city);
    }
     */
}
