package managers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import config.SelenoidWebDriverConfig;
import drivers.SelenoidMobileDriver;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;

public class SelenoidMobileWDManager extends AbstractWDManager {

    private static final SelenoidWebDriverConfig config = ConfigFactory.create(SelenoidWebDriverConfig.class);

    public static SelenoidMobileWDManager create() {
        SelenoidMobileDriver.config = config;
        return new SelenoidMobileWDManager();
    }

    @Override
    public void configureBeforeAll() {
        Configuration.browser = SelenoidMobileDriver.class.getName();
    }

    @AfterEach
    void afterEach() {
        Selenide.clearBrowserLocalStorage();
        Selenide.clearBrowserCookies();
    }
}
