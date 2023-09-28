package android.project.duolingo.duolingoTest;

import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    private static AndroidDriver driver;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium:app", "C:\\Users\\user\\Desktop\\Duolingo_ Language Lessons_5.121.4_Apkpure.apk");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:automationName", "UiAutomator2");
        desiredCapabilities.setCapability("appium:deviceName", "Pixel 5");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);
        desiredCapabilities.setCapability("autoGrantPermissions", true); // отвечает за отключение системных оповещений эмулятора
        URL remoteURL = new URL("http://127.0.0.1:4723");

        driver = new AndroidDriver(remoteURL, desiredCapabilities);

    }

    public static AndroidDriver getDriver() {
        return driver;
    }

    @AfterEach
    public void tearDown() {
        try {
            Thread.sleep(2000); // Ожидание 2 секунды
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }


}
