import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.net.MalformedURLException;
import java.net.URL;

public class FavoriteTest {


    static AppiumDriver driver;


    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        openMobileApp();


    }

    private static void openMobileApp() throws MalformedURLException, InterruptedException {


        DesiredCapabilities cap = new DesiredCapabilities();


        cap.setCapability("platformName", "Android");
        cap.setCapability("deviceName", "TestPhone");
        cap.setCapability("udid", "FFY5T17C16036747");
        cap.setCapability("platformVersion", "8");
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("autoGrantPermissions", true);
        cap.setCapability("appPackage", "com.nahdi.main");
        cap.setCapability("appActivity", "com.nahdi.sirius.staging.MainActivity");

        URL url = new URL("http://127.0.0.1:4723/");
        driver = new AppiumDriver(url, cap);


        Thread.sleep(2000);

        driver.findElement(new By.ByXPath("//android.widget.ImageView[@content-desc=\"Continue\"]\n")).click();

        Thread.sleep(2000);

        driver.findElement(new By.ByXPath("//android.widget.ImageView[@content-desc=\"Continue\"]")).click();

        Thread.sleep(2000);

        driver.findElement(new By.ByXPath("//android.view.View[@content-desc=\"Skip\"]\n")).click();

        Thread.sleep(2000);

        WebElement element = driver.findElement(By.xpath("//android.widget.EditText\n"));
        element.click();
        Thread.sleep(2000);
        element.sendKeys("550345600");

        Thread.sleep(2000);

        driver.findElement(new By.ByXPath("//android.view.View[@content-desc=\"Continue\"]\n")).click();

        Thread.sleep(4000);

        driver.findElement(new By.ByXPath("//android.view.View[@content-desc=\"Login with password instead\"]\n")).click();

        Thread.sleep(4000);

        WebElement element1 = driver.findElement(By.xpath("//android.widget.EditText"));
        element1.click();
        Thread.sleep(2000);
        element1.sendKeys("Augmentin123");


        Thread.sleep(4000);

        driver.findElement(new By.ByXPath("//android.view.View[@content-desc=\"Continue\"]\n")).click();

        Thread.sleep(12000);

        driver.findElement(new By.ByXPath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]\n")).click();


        Thread.sleep(4000);

        driver.findElement(By.xpath("//android.widget.EditText")).sendKeys("panadol");


        Thread.sleep(6000);

        driver.findElement(new By.ByXPath("//android.view.View[@content-desc=\"panadol\"]\n")).click();

        Thread.sleep(4000);

        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().className(\"android.view.View\").instance(19)\n")).click();

        Thread.sleep(4000);

        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(20)\n")).click();


        Thread.sleep(5000);

        driver.quit();


    }

}




