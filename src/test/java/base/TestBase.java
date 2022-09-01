package base;

import managers.AbstractWDManager;
import managers.BrowserstackMobileWDManager;
import managers.LocalMobileWDManager;
import managers.SelenoidMobileWDManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {

    private static final AbstractWDManager manager;

    static {
        String deviceHost = System.getProperty("deviceHost");
        switch (deviceHost) {
            case "browserstack":
                manager = BrowserstackMobileWDManager.create();
                break;
            case "emulator":
                manager = LocalMobileWDManager.create(false);
                break;
            case "real":
                manager = LocalMobileWDManager.create(true);
                break;
            case "selenoid":
                manager = SelenoidMobileWDManager.create();
                break;
            default:
                throw new RuntimeException();
        }
    }

    @BeforeAll
    public static void beforeAll() {
        manager.configureBeforeAll();
    }

    @BeforeEach
    public void beforeEach() {
        manager.configureBeforeEach();
    }

    @AfterEach
    public void afterEach() {
        manager.configureAfterEach();
    }

    @AfterAll
    public static void afterAll() {
        manager.configureAfterAll();
    }
}
