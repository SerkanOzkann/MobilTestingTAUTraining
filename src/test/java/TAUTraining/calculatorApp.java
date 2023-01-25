package TAUTraining;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class calculatorApp {
    public AppiumDriver driver;

    // Gerekli idlerin tanımlamarı yapılmıştır.

    By ucNumber = By.id("digit_3");
    By plus = By.id("op_add");

    By altiNumber = By.id("digit_6");

    By equal = By.id("eq");

    By minus = By.id("op_sub");

    By dokuzNumber = By.id("digit_9");




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
            cap.setCapability("appPackage", "com.google.android.calculator");
            cap.setCapability("appActivity", "com.android.calculator2.Calculator");
            cap.setCapability("noReset", "false");

            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap); // Gerekli Appium Server bilgisinin girişi sağlanır.

        }
        catch (MalformedURLException test){
            System.out.println("Hatalı");
        }
    }

    @Test

    public void test(){
        // Yapılan işlem hesap makinesi ile 3+6=9 9-9 =0  0 ise Doğru  çıktısını alabilmektir.

      driver.findElement(ucNumber).click();
      driver.findElement(plus).click();
      driver.findElement(altiNumber).click();
      driver.findElement(equal).click();
      driver.findElement(minus).click();
      driver.findElement(dokuzNumber).click();
      driver.findElement(equal).click();

      Assert.assertEquals(driver.findElement(By.id("result_final")).getText(),"0");


    }
    @AfterTest
    public void teardown(){
        driver.quit();
    }

}
