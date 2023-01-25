package TAUTraining;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public class firstTest {

    public AppiumDriver driver;
    public AndroidTouchAction actions;


  By appButton =  By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.ListView/android.widget.TextView[3]");
  // Uygulama içinde bulunan App sekmesine tıklaması için gerekli xpath kodu tanımlaması yapılır.

    By viewsButton = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.ListView/android.widget.TextView[13]");

    By listButton= By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.ListView/android.widget.TextView[8]");

    By dragDrop = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.ListView/android.widget.TextView[8]");
    By dragDrop1= By.id("drag_dot_1");
    By DragDrop2 = By.id("drag_dot_2");
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
            cap.setCapability("appPackage", "com.touchboarder.android.api.demos");
            cap.setCapability("appActivity", "com.example.android.apis.ApiDemos");
            cap.setCapability("noReset", "true");

            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap); // Gerekli Appium Server bilgisinin girişi sağlanır.

        }
        catch (MalformedURLException test){
            System.out.println("Hatalı");
        }
    }

    private void scrollDown() {
        //scrollDown İşlemleri için gerekli kodlar.
        Dimension dimension = driver.manage().window().getSize();
        int scrollStart = (int) (dimension.getHeight() * 0.8);
        int scrollEnd = (int) (dimension.getHeight() * 0.1);

        actions = new AndroidTouchAction(driver)
                .press(PointOption.point(0, scrollStart))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(0, scrollEnd))
                .release()
                .perform();
    }
    @Test

    public void test() throws InterruptedException {
     //driver.findElement(appButton).click();  // Yukarda tanımlaması yapılan app butonuna tıklatılır.

        // Uygulama açıldıktan sonra scrollDowm yapılır. viewsbutton tıklanır tekrar scrollDown yapılır. Listbutton tıklanır.
//        scrollDown();
//        Thread.sleep(1000);
        AndroidElement views = (AndroidElement) driver.findElement(viewsButton);
        actions = new AndroidTouchAction(driver);
        actions.tap(ElementOption.element(views)).perform();
//        scrollDown();
//        Thread.sleep(1000);
//        AndroidElement lists = (AndroidElement) driver.findElement(listButton);
//        actions.tap(ElementOption.element(lists)).perform();
//        Thread.sleep(1000);
        // Uygulama açıldıktan sonra scrollDowm yapılır. viewsbutton tıklanır tekrar scrollDown yapılır. Listbutton tıklanır.



// Uygulama açıldıktan sonra viewsbutton tıklanır. dragDrop menusune tıklanır. dragdrop1 ve dragdrop2 butonlarına sırayla tıklanır.
//        AndroidElement drag_drop = (AndroidElement) driver.findElement(dragDrop);
//        actions.tap(ElementOption.element(drag_drop)).perform();
//        Thread.sleep(1000);
//        AndroidElement drag = (AndroidElement) driver.findElement(dragDrop1);
//        Thread.sleep(1000);
//        AndroidElement drop = (AndroidElement) driver.findElement(DragDrop2);
//        Thread.sleep(1000);
//
//        actions.longPress(ElementOption.element(drag))
//                .waitAction().moveTo(ElementOption.element(drop))
//                .release()
//                .perform();
// Uygulama açıldıktan sonra viewsbutton tıklanır. dragDrop menusune tıklanır. dragdrop1 ve dragdrop2 butonlarına sırayla tıklanır.





    }
    @AfterTest
    public void teardown(){
        driver.quit();
    }


}
