package managers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import config.SelenoidWebDriverConfig;
import drivers.SelenoidMobileDriver;
import helpers.Attach;
import org.aeonbits.owner.ConfigFactory;

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

    @Override
    public void configureAfterEach() {
        Selenide.clearBrowserLocalStorage();
        Selenide.clearBrowserCookies();
        super.configureAfterEach();
        String videoUrl = getVideoUrl();
        Attach.addVideo(videoUrl);
    }

    private String getVideoUrl() {
        return String.format("%s/%s.mp4", config.getVideoPath(), getSessionId());
    }
}
