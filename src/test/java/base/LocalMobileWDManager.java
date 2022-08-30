package base;

import com.codeborne.selenide.Configuration;
import drivers.LocalMobileDriver;

public class LocalMobileWDManager extends AbstractWDManager {

    public LocalMobileWDManager(Boolean isDevice) {
        LocalMobileDriver.isRealDevice = isDevice;
    }

    @Override
    public void configureBeforeAll() {
        Configuration.browser = LocalMobileDriver.class.getName();
        Configuration.browserSize = null;
    }

    @Override
    String getVideoUrl(String sessionId) {
        return null;
    }
}
