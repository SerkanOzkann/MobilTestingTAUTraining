package TAUTraining;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class messagesApp {
    public AndroidDriver driver; // sendSMS elementi için  android driver tanımlaması yaparız



    @BeforeTest
    public void beforeTest(){
        // Emulator Cihaz İçin gerekli tanımlamaların yapıldığı kısımdır. deviceName, platformName, platformVersion, appPackage, appActivity, noReset bilgilerinin girişleri yapılır. Bu bilgilere "DesiredCapabilities" denir.
        // DesiredCapabilitiesler "cap" adında değişkene aktarılarak setCapabilitylerin girişleri yapılır.

        try {
            DesiredCapabilities cap;
            cap = new DesiredCapabilities();

            cap.setCapability("deviceName", "Pixel 2 API 30");
            cap.setCapability("platformName", "Android");
            cap.setCapability("platformVersion", "11.0");
            cap.setCapability("appPackage", "com.google.android.apps.messaging");
            cap.setCapability("appActivity", ".ui.ConversationListActivity"); // sms gondermek için appActıvıty
            cap.setCapability("noReset", "true");

            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap); // Gerekli Appium Server bilgisinin girişi sağlanır.

        }
        catch (MalformedURLException test){
            System.out.println("Hatalı");
        }
    }
    @Test

    public void test() throws InterruptedException {

        driver.sendSMS("555-123-4567","Hello from TAU");
        Thread.sleep(5000);
    }
    @AfterTest
    public void teardown(){
        driver.quit();
    }


}

