package factoryDevices;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Android implements IDevice{
    @Override
    public AppiumDriver create() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","mobileAlarma");
        capabilities.setCapability("platformVersion","11");
        capabilities.setCapability("appPackage","com.google.android.deskclock");
        capabilities.setCapability("appActivity","com.android.deskclock.DeskClock");

        capabilities.setCapability("platformName","Android");
        AppiumDriver driver= null;
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        // implicit
      //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        return driver;
    }
}
