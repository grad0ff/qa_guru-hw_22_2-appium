package base;

import managers.AbstractWDManager;
import managers.BrowserstackMobileWDManager;
import managers.LocalMobileWDManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {

    private static AbstractWDManager manager;

    static {
        String deviceHost = System.getProperty("-DdeviceHost", "browserstack"); // TODO: 30.08.2022 удалить default значение
        switch (deviceHost) {
            case "emulator":
                manager = LocalMobileWDManager.create(false);
                break;
            case "real":
                manager = LocalMobileWDManager.create(true);
                break;
            case "browserstack":
                manager = BrowserstackMobileWDManager.create();
                break;
            case "selenoid":
                // TODO: manager = new SelenoidMobileWDManager();
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
