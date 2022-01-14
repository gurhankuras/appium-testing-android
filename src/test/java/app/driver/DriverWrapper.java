package app.driver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

// Not a good approach but for now i have to use it to share it between tests
public class DriverWrapper {
    public static AndroidDriver<MobileElement> driver;

    public static AndroidDriver<MobileElement> getDriver() {
        return driver;
    }

    public static void init() throws MalformedURLException {
        if (driver == null) {
            var capabilities = DriverWrapper.getDesiredCapabilities();
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        }
    }

    private static DesiredCapabilities getDesiredCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        // capabilities.setCapability("platformVersion", "11");
        capabilities.setCapability("deviceName", "sdk_gphone_arm64");
        capabilities.setCapability("udid", "emulator-5554");
        capabilities.setCapability("appPackage", "com.ealeynaelmas.firstandroidapp");
        capabilities.setCapability("appActivity", "com.ealeynaelmas.firstandroidapp.MainActivity");
        return capabilities;
    }

    public static void reset() {
        driver.quit();
        driver = null;
    }
}
