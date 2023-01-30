package TAUTraining;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase {

    public static AppiumDriver driver;

    public static void Android_setUp() throws MalformedURLException {
        try {
        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability("deviceName", "Pixel 2 API 30");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "11.0");
        cap.setCapability("deviceName", "Android Emulator");
        cap.setCapability("appPackage", "com.jeffprod.todo");
        cap.setCapability("appActivity", "com.jeffprod.todo.ActivityMain");
        cap.setCapability("noReset", "true");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap); // Gerekli Appium Server bilgisinin girişi sağlanır.

    }
        catch (
    MalformedURLException test){
        System.out.println("Hatalı");
    }
}

    public static void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }
}
