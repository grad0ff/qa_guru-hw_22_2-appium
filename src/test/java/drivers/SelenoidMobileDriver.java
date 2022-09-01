package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.SelenoidWebDriverConfig;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class SelenoidMobileDriver implements WebDriverProvider {

    public static SelenoidWebDriverConfig config;

    private static URL getSelenoidServerUrl() {
        try {
            return new URL(config.getServerUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.merge(capabilities);
        desiredCapabilities.setCapability("browserName", config.getBrowserName());
        desiredCapabilities.setCapability("browserVersion", config.getBrowserVersion());
        desiredCapabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        return new RemoteWebDriver(getSelenoidServerUrl(), desiredCapabilities);
    }
}
