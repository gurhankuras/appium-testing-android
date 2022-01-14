package app.tests;

import app.driver.DriverWrapper;
import app.pageobjects.AddHotelPageObject;
import app.pageobjects.MainPageObject;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class AddHotelTest {
   // public AndroidDriver<MobileElement> driver;
    public AddHotelPageObject page;

    @Before()
    public void setUp() throws Exception {
/*
        DesiredCapabilities capabilities = new DesiredCapabilities();
        // capabilities.setCapability("platformVersion", "11");
        capabilities.setCapability("deviceName", "sdk_gphone_arm64");
        capabilities.setCapability("udid", "emulator-5554");
        capabilities.setCapability("appPackage", "com.ealeynaelmas.firstandroidapp");
        capabilities.setCapability("appActivity", "com.ealeynaelmas.firstandroidapp.MainActivity");

        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

*/
        DriverWrapper.init();
        page = new AddHotelPageObject(DriverWrapper.getDriver());
    }


    @After()
    public void cleanup() {
        DriverWrapper.reset();
    }





    @Given("I am on Add Hotel Page")
    public void iAmOnAddHotelPage() {
        page.goToPage();
    }

    @When("^I fill in hotel name field with (.*)$")
    public void iFillHotelNameFieldWith(String hotelName) {
        page.fillHotelName(hotelName);
    }

    @And("^I fill in hotel city field with (.*)$")
    public void iFillHotelCityFieldWithCity(String city) {
        page.fillHotelCity(city);
    }

    @And("^I fill in hotel location field with (.*)$")
    public void iFillHotelLocationFieldWithLocation(String location) {
        page.fillHotelLocation(location);
    }

    @And("^I fill in hotel price field with (.*)$")
    public void iFillHotelPriceFieldWithPrice(String price) {
        page.fillHotelPrice(price);
    }

    @And("^I fill in license no field with (.*)$")
    public void iFillLicenseNoFieldWithLicenseNo(String licenseNo) {
        page.fillLicenseNo(licenseNo);
    }

    @And("^I fill in business license no field with (.*)$")
    public void iFillBusinessLicenseNoFieldWithBusinessLicenseNo(String businessLicenseNo) {
        page.fillBusinessLicenseNo(businessLicenseNo);
    }


    @And("^I click on Add Hotel button expecting (success|failure)$")
    public void iClickAddHotelButtonExpectingFailure(String expectation) {
        if (expectation.equals("failure")) {
            //page.searchAsExpectingError();
        }
        else {
            //page.search();
        }
        var mainPage = page.addHotel();
        Assert.assertEquals(mainPage.getTitleElement().getAttribute("text"), MainPageObject.titleText);
    }


    @And("^I (select|don't select) image from library$")
    public void iSelectImageFromLibrary(String selection) {
        if (selection.equals("select")) {
            page.selectImageFor(1);
        }
    }

    @And("^I (check|don't check) a hotel attribute$")
    public void iCheckAHotelAttribute(String check) {
        if (check.equals("check")) {
            page.toggleHotelAttribute(1);
        }
    }


}
