package app.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class HotelList {
    AndroidDriver<MobileElement> driver;

    public HotelList(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }
}
