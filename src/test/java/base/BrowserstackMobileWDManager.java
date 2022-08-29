package base;

import com.codeborne.selenide.Configuration;
import drivers.BrowserstackMobileDriver;
import helpers.Attach;

public class BrowserstackMobileWDManager extends AbstractWDManager {

    @Override
    void configureBeforeAll() {
        Configuration.browser = BrowserstackMobileDriver.class.getName();
        Configuration.browserSize = null;
    }

    @Override
    void configureAfterEach() {
        String sessionId = Attach.getSessionId();
        super.configureAfterEach();
        Attach.addVideo(sessionId);
    }
}
