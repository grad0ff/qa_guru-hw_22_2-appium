package managers;

import com.codeborne.selenide.Configuration;
import config.LocalDriverConfig;
import drivers.LocalMobileDriver;
import org.aeonbits.owner.ConfigFactory;

public class LocalMobileWDManager extends AbstractWDManager {

    private static final LocalDriverConfig config = ConfigFactory.create(LocalDriverConfig.class);

    public static LocalMobileWDManager create(Boolean isDevice) {
        LocalMobileDriver.config = config;
        LocalMobileDriver.isRealDevice = isDevice;
        return new LocalMobileWDManager();
    }

    @Override
    public void configureBeforeAll() {
        Configuration.browser = LocalMobileDriver.class.getName();
        Configuration.browserSize = null;
    }
}
