package TAUTraining;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class pomExample {

    private AppiumDriver driver;

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
            cap.setCapability("appPackage", "com.jeffprod.todo");
            cap.setCapability("appActivity", ".com.jeffprod.todo.ActivityMain"); //
            cap.setCapability("noReset", "true");

            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap); // Gerekli Appium Server bilgisinin girişi sağlanır.

        }
        catch (MalformedURLException test){
            System.out.println("Hatalı");
        }
    }
    @Test

    public void test() throws InterruptedException {




    }
    @AfterTest
    public void teardown(){
        driver.quit();
    }


}
