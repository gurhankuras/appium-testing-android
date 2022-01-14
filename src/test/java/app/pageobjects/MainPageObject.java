package app.pageobjects;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPageObject {
    AndroidDriver<MobileElement> driver;

    // Text Fields
    public By cityTextFieldLocator = MobileBy.id("com.ealeynaelmas.firstandroidapp:id/City");
    By numberOfPersonTextFieldLocator = MobileBy.id("com.ealeynaelmas.firstandroidapp:id/NumberOfPerson");
    By checkInTextFieldLocator = MobileBy.id("com.ealeynaelmas.firstandroidapp:id/CheckInDate");
    By checkOutTextFieldLocator = MobileBy.id("com.ealeynaelmas.firstandroidapp:id/CheckOutDate");
    By numberOfChildTextFieldLocator = MobileBy.id("com.ealeynaelmas.firstandroidapp:id/NumberOfChild");

    // Buttons
    By searchButton = MobileBy.id("com.ealeynaelmas.firstandroidapp:id/SearchButton");



    // Title
    By title = MobileBy.id("com.ealeynaelmas.firstandroidapp:id/textView27");

    // Text
    public static String titleText = "Nereye Gitmek İstersin?";
    public static String emptyFieldWarningText = "Lütfen tüm alanları giriniz!";
    public static String notFoundWarningText = "Bu sehire ait otel bulunamadi";

    public MainPageObject(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }


    // Functions
    public HotelList search() {
        var search = new WebDriverWait(driver, 2)
                .until(ExpectedConditions.visibilityOfElementLocated(searchButton));
        search.click();
        return new HotelList(driver);
    }

    public HotelList navigatesToAvailableHotels() {
        loadFormData();
        return search();
    }

    public MainPageObject searchAsExpectingError() {
        var search = new WebDriverWait(driver, 2)
                .until(ExpectedConditions.visibilityOfElementLocated(searchButton));
        search.click();
        return this;
    }

    public MobileElement getTitleElement() {
        var titleElement = (MobileElement) new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(title));
        return titleElement;
    }

    public void loadFormData() {
        fillCity("Duzce");
        fillCheckIn("14/02/2022");
        fillCheckOut("16/02/2022");
        fillNumberOfPerson("2");
        fillNumberOfChild("1");
    }

    public void fillCity(String text) {
        fill(cityTextFieldLocator, text);
    }

    public void fillCheckIn(String text) {
        fill(checkInTextFieldLocator, text);
    }

    public void fillCheckOut(String text) {
        fill(checkOutTextFieldLocator, text);
    }

    public void fillNumberOfPerson(String text) {
        fill(numberOfPersonTextFieldLocator, text);
    }

    public void fillNumberOfChild(String text) {
        fill(numberOfChildTextFieldLocator, text);
    }

    public void fill(By selector, String text) {
        System.out.println(selector);
        var field = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(selector));
        //cityField.click();
        field.clear();
        field.sendKeys(text);
    }
}
