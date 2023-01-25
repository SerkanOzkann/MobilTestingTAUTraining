package TAUTraining;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
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





//            WebElement urlBar = driver.findElementById("url_bar");
//            urlBar.sendKeys("https://the-internet.herokuapp.com/login");
//            Actions action=new Actions(driver);
//            action.sendKeys(Keys.ENTER);



//            driver.get("https://the-internet.herokuapp.com/login");
//            driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
//            WebElement username = driver.findElementByCssSelector("input#username");
//            username.sendKeys("tomsmith");
//            WebElement password = driver.findElementByCssSelector("input#password");
//            password.sendKeys("SuperSecretPassword!");
//            WebElement loginBtn = driver.findElementByCssSelector("button.radius");
//            loginBtn.click();
//            WebDriverWait wait = new WebDriverWait(driver, 10);
//            wait.until(ExpectedConditions.urlContains("secure"));
//            Assert.assertTrue(driver.getCurrentUrl().contains("secure"));
//            System.out.println(driver.getCurrentUrl());

        }
        @AfterTest
        public void teardown(){
            driver.quit();
        }


    }




