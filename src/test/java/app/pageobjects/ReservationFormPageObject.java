package app.pageobjects;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ReservationFormPageObject {
    AndroidDriver<MobileElement> driver;

    By titleLocator = MobileBy.id("com.ealeynaelmas.firstandroidapp:id/textView19");
    private static String titleText = "İrtibat Bilgileri";

    By contactNameTextFieldLocator = MobileBy.id("com.ealeynaelmas.firstandroidapp:id/ContactName");
    By contactLastNameTextFieldLocator = MobileBy.id("com.ealeynaelmas.firstandroidapp:id/ContactLastName");
    By contactEmailTextFieldLocator = MobileBy.id("com.ealeynaelmas.firstandroidapp:id/ContactMail");
    By contactPhoneTextFieldLocator = MobileBy.id("com.ealeynaelmas.firstandroidapp:id/ContactPhone");

    By personNameTextFieldLocator = MobileBy.id("com.ealeynaelmas.firstandroidapp:id/PersonName");
    By personLastNameTextFieldLocator = MobileBy.id("com.ealeynaelmas.firstandroidapp:id/PersonLastName");
    By personTCTextFieldLocator = MobileBy.id("com.ealeynaelmas.firstandroidapp:id/PersonTC");
    By personPhoneTextFieldLocator = MobileBy.id("com.ealeynaelmas.firstandroidapp:id/PersonPhone");

    By iHaveRequestRadioButtonLocator = MobileBy.id("com.ealeynaelmas.firstandroidapp:id/radioButton1");
    By iHaveNotRequestRadioButtonLocator = MobileBy.id("com.ealeynaelmas.firstandroidapp:id/radioButton2");
    By requestTextFieldLocator = MobileBy.id("com.ealeynaelmas.firstandroidapp:id/wishText");

    By submitButtonLocator = MobileBy.id("com.ealeynaelmas.firstandroidapp:id/button2");


    public ReservationFormPageObject(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public boolean isTitleShown() {
        var title = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(titleLocator));
        return title.getAttribute("text").equals(ReservationFormPageObject.titleText);
    }

    public ReservationFormPageObject fillContactSection() {
        this.fill(contactNameTextFieldLocator, "Hayri")
                .fill(contactLastNameTextFieldLocator, "Ali")
                .fill(contactEmailTextFieldLocator, "hayriali@hotmail.com")
                .fill(contactPhoneTextFieldLocator, "05455545454");
        return this;
    }

    public ReservationFormPageObject fillResidentSection() {
        this.fill(personNameTextFieldLocator, "Hayri")
                .fill(personLastNameTextFieldLocator, "Ali")
                .fill(personTCTextFieldLocator, "21484486694")
                .fill(personPhoneTextFieldLocator, "05455545454");
        return this;
    }
    private By getLocatorByFieldName(String fieldName) {
        return switch (fieldName) {
            case "name" -> personNameTextFieldLocator;
            case "email" -> contactEmailTextFieldLocator;
            case "phone" -> contactPhoneTextFieldLocator;
            case "TC" -> personTCTextFieldLocator;
            case "lastname" -> personLastNameTextFieldLocator;
            default -> throw new InvalidArgumentException(String.format("Invalid fieldName: %s", fieldName));
        };
    }

    public void fillByFieldName(String fieldName, String value) {
        fill(getLocatorByFieldName(fieldName), value);
    }

    public ReservationFormPageObject makeRequest() {
        selectMakeRequest();
        return fill(requestTextFieldLocator, "klima");
    }

    public WebElement selectMakeRequest() {
        var makeRequestRadio = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(iHaveRequestRadioButtonLocator));
        makeRequestRadio.click();
        return makeRequestRadio;
    }

    public boolean isMakeRequestTextFieldVisible() {
        var requestTextField = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(requestTextFieldLocator));
        return true;
    }

    public MainPageObject submitForm() {
        var submitButton = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(submitButtonLocator));
        submitButton.click();
        return new MainPageObject(driver);
    }

    public ReservationFormPageObject fill(By selector, String text) {
        System.out.println(selector);
        var field = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(selector));
        //cityField.click();
        field.clear();
        field.sendKeys(text);
        return this;
    }
}
