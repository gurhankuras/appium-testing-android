package app.utils;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestHelper {
    private static final By toast = MobileBy.xpath("/hierarchy/android.widget.Toast");

    public static String getToastText(WebDriver driver) {
        WebDriverWait waitForToast = new WebDriverWait(driver, 25);
        waitForToast.until(ExpectedConditions.presenceOfElementLocated(TestHelper.toast));

        String toastMessage = driver.findElement(TestHelper.toast).getAttribute("text");
        return toastMessage;
    }

    public static String getId(String suffix) {
        return String.format("%s%s", "com.ealeynaelmas.firstandroidapp:id/", suffix);
    }


}
