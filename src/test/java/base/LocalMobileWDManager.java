package base;

import com.codeborne.selenide.Configuration;
import drivers.LocalMobileDriver;

public class LocalMobileWDManager extends AbstractWDManager {

    @Override
    public void configureBeforeAll() {
        Configuration.browser = LocalMobileDriver.class.getName();
        Configuration.browserSize = null;
    }
}
