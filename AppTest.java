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

public class AppTest {


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

        driver.findElement( new By.ByXPath("//android.widget.ImageView[@content-desc=\"Continue\"]\n")).click();

        Thread.sleep(2000);

        driver.findElement( new By.ByXPath("//android.widget.ImageView[@content-desc=\"Continue\"]")).click();

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

        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().className(\"android.view.View\").instance(20)\n") ).click();

        Thread.sleep(6000);

        driver.findElement(By.xpath("//android.widget.ImageView[contains(@content-desc, 'Cart')]")).click();


        Thread.sleep(8000);

        driver.findElement(new By.ByXPath("//android.widget.ImageView[@content-desc=\"Checkout\"]\n")).click();

        Thread.sleep(8000);

        driver.findElement(new By.ByXPath("//android.view.View[@content-desc=\"Day\"]\n")).click();

        Thread.sleep(4000);

        // List of time slots in priority order
        String[] timeSlots = {
                "13:00-15:00",
                "15:00-17:00",
                "17:00-19:00",
                "19:00-21:00",
                "21:00"
        };

        boolean slotFound = false;

        for (String slot : timeSlots) {
            String xpath = "//android.widget.ImageView[@content-desc='" + slot + "']";
            List<WebElement> elements = driver.findElements(By.xpath(xpath));

            if (!elements.isEmpty()) {
                WebElement availableSlot = elements.get(0);
                availableSlot.click();
                System.out.println("Selected time slot: " + slot);
                slotFound = true;
                break;
            }
        }

        if (!slotFound) {
            System.out.println("Could not find any available time slots.");
        }


        Thread.sleep(4000);


        driver.findElement(By.xpath("//android.view.View[@content-desc=\"Confirm\"]")).click();


        Thread.sleep(4000);


        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(" +
                        "new UiSelector().description(\"Cash on delivery\"))"
        ));

        Thread.sleep(4000);


        driver.findElement(By.xpath("//android.view.View[@content-desc=\"Cash on delivery\"]")).click();



        Thread.sleep(4000);

        driver.findElement(new By.ByXPath("//android.view.View[@content-desc=\"Place Order\"]\n")).click();


        Thread.sleep(6000);


        List<WebElement> confirmationMessages = driver.findElements(By.xpath("//android.view.View[@content-desc='Order Confirmed']"));

        if (!confirmationMessages.isEmpty()) {
            System.out.println("Order confirmed successfully!");
        } else {
            System.out.println("Order confirmation message not found!");
        }

        driver.quit();
























    }


}
