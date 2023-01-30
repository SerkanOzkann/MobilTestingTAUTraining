package TAUTraining;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class webTestWithChrome {

    public AppiumDriver driver;

    By webBrowser = By.id("search_box_text");
    By urlBar = By.id("url_bar");

    By siteLogin = By.id("username");

    By sitePassword = By.id("password");

    By loginButton = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[5]/android.view.View[3]/android.widget.Button");

    By web = By.xpath("//android.widget.FrameLayout[@content-desc=\"Web Görüntüleme\"]");

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
                cap.setCapability("appPackage", "com.android.chrome");
                cap.setCapability("appActivity", "org.chromium.chrome.browser.document.ChromeLauncherActivity");
                cap.setCapability("noReset", "true");

                driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap); // Gerekli Appium Server bilgisinin girişi sağlanır.

            }
            catch (MalformedURLException test){
                System.out.println("Hatalı");
            }
        }
        @Test
        public void test() throws InterruptedException {
            driver.findElement(webBrowser).click();
            Thread.sleep(3000);
            WebElement urlBarSearch = driver.findElement(urlBar);
            urlBarSearch.sendKeys("https://the-internet.herokuapp.com/login");
            Thread.sleep(3000);
            driver.getKeyboard().pressKey(Keys.ENTER);
            Thread.sleep(9000);
            driver.findElement(web).click();
            Thread.sleep(3000);
           /* driver.findElement(siteLogin).click();
            driver.findElement(siteLogin).sendKeys("tomsmith");*/
            Thread.sleep(3000);
            driver.findElement(sitePassword).click();
            driver.findElement(sitePassword).sendKeys("SuperSecretPassword!");
            Thread.sleep(3000);
            driver.findElement(loginButton).click();
            Thread.sleep(9000);





        }
        @AfterTest
        public void teardown(){
            driver.quit();
        }


    }




