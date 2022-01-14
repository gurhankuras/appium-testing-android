package app.pageobjects;

import app.utils.TestHelper;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddHotelPageObject {
    AndroidDriver<MobileElement> driver;

    By createHotelButtonLocator = MobileBy.id(TestHelper.getId("CreateHotelButton"));

    By hotelNameTextInputLocator = MobileBy.id(TestHelper.getId("HotelName"));
    By hotelCityTextInputLocator = MobileBy.id(TestHelper.getId("HotelCity"));
    By hotelLocationTextInputLocator = MobileBy.id(TestHelper.getId("HotelLocation"));
    By hotelPriceTextInputLocator = MobileBy.id(TestHelper.getId("HotelCost"));

    By licenseNumberTextInputLocator = MobileBy.id(TestHelper.getId("LicanceNo"));
    By businessLicenseNumberTextInputLocator = MobileBy.id(TestHelper.getId("DocumentNo"));

    By addHotelButtonLocator = MobileBy.id(TestHelper.getId("button7"));
    //By uploadImageButton1 = MobileBy.id(TestHelper.getId("UploadImageButton1"));

    public AddHotelPageObject(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public MainPageObject addHotel() {
        var addHotelButton = new WebDriverWait(driver, 2)
                .until(ExpectedConditions.visibilityOfElementLocated(addHotelButtonLocator));
        addHotelButton.click();
        return new MainPageObject(driver);
    }

    public void selectImageFor(int nthImage) {
        var formattedIdStr = String.format("UploadImageButton%d", nthImage);
        var imageButtonLocator = MobileBy.id(TestHelper.getId(formattedIdStr));
        var imageButton = new WebDriverWait(driver, 2)
                .until(ExpectedConditions.visibilityOfElementLocated(imageButtonLocator));
        imageButton.click();
        var firstImagelocator = MobileBy.id("com.google.android.documentsui:id/icon_thumb");
        var image = new WebDriverWait(driver, 2)
                .until(ExpectedConditions.visibilityOfElementLocated(firstImagelocator));
        image.click();
    }

    public void toggleHotelAttribute(int nthAttribute) {
        var formattedIdStr = String.format("Attribute%d", nthAttribute);
        var attributeCheckboxLocator = MobileBy.id(TestHelper.getId(formattedIdStr));
        var attributeCheckbox = new WebDriverWait(driver, 2)
                .until(ExpectedConditions.visibilityOfElementLocated(attributeCheckboxLocator));
        attributeCheckbox.click();
    }



    public void goToPage() {
         var button = new WebDriverWait(driver, 2)
                .until(ExpectedConditions.visibilityOfElementLocated(createHotelButtonLocator));
         button.click();
    }

    public AddHotelPageObject fillHotelName(String text) {
        fill(hotelNameTextInputLocator, text);
        return this;
    }

    public AddHotelPageObject fillHotelCity(String text) {
        fill(hotelCityTextInputLocator, text);
        return this;
    }
    public AddHotelPageObject fillHotelPrice(String text) {
        fill(hotelPriceTextInputLocator, text);
        return this;
    }
    public AddHotelPageObject fillHotelLocation(String text) {
        fill(hotelLocationTextInputLocator, text);
        return this;
    }
    public AddHotelPageObject fillLicenseNo(String text) {
        fill(licenseNumberTextInputLocator, text);
        return this;
    }
    public AddHotelPageObject fillBusinessLicenseNo(String text) {
        fill(businessLicenseNumberTextInputLocator, text);
        return this;
    }

    public void fill(By selector, String text) {
        var field = new WebDriverWait(driver, 2)
                .until(ExpectedConditions.visibilityOfElementLocated(selector));
        //cityField.click();
        field.clear();
        field.sendKeys(text);
    }
}
