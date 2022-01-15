package app.pageobjects;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HotelDetailsPageObject {
    AndroidDriver<MobileElement> driver;

    By reservationButtonLocator = MobileBy.id("com.ealeynaelmas.firstandroidapp:id/button");

    public HotelDetailsPageObject(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public ReservationFormPageObject showReservationForm() {
        var reservationButton = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(reservationButtonLocator));
        reservationButton.click();
        return new ReservationFormPageObject(driver);
    }
}
