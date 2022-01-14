package app.pageobjects;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HotelList {
    AndroidDriver<MobileElement> driver;

    By hotelTileLocator = MobileBy.id("com.ealeynaelmas.firstandroidapp:id/hotel_view");
    By showHotelDetailsButtonLocator = MobileBy.id("com.ealeynaelmas.firstandroidapp:id/showHotel");

    By hotelPriceTextLocator = MobileBy.id("com.ealeynaelmas.firstandroidapp:id/cost");
    By hotelLocationTextLocator = MobileBy.id("com.ealeynaelmas.firstandroidapp:id/location");
    By hotelNameTextLocator = MobileBy.id(
            "com.ealeynaelmas.firstandroidapp:id/hotelName");
    By hotelThumbnailLocator = MobileBy.id("com.ealeynaelmas.firstandroidapp:id/hotelImage");


    public HotelList(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public boolean hasAnyMatchingHotel() {
        var hotel = new WebDriverWait(driver, 2)
                .until(ExpectedConditions.visibilityOfElementLocated(hotelTileLocator));
        return hotel != null;
    }

    public boolean hasAllSummaryInfo() {
        var name = new WebDriverWait(driver, 2)
                .until(ExpectedConditions.visibilityOfElementLocated(hotelNameTextLocator));
        var thumbnail = new WebDriverWait(driver, 2)
                .until(ExpectedConditions.visibilityOfElementLocated(hotelThumbnailLocator));
        var price = new WebDriverWait(driver, 2)
                .until(ExpectedConditions.visibilityOfElementLocated(hotelPriceTextLocator));
        var location = new WebDriverWait(driver, 2)
                .until(ExpectedConditions.visibilityOfElementLocated(hotelLocationTextLocator));

        return isNotBlank(name) && isNotBlank(price) && isNotBlank(location);
    }

    private boolean isNotBlank(WebElement textElement) {
        return !textElement.getAttribute("text").isBlank();
    }

}
