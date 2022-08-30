package base;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class MainTestBase {

    private static AbstractWDManager manager;

    static {
        String deviceHost = System.getProperty("-DdeviceHost", "emulator"); // TODO: 30.08.2022 undefined
        switch (deviceHost) {
            case "emulator":
                manager = new LocalMobileWDManager(false);
                break;
            case "device":
                manager = new LocalMobileWDManager(true);
                break;
            case "browserstack":
                manager = new BrowserstackMobileWDManager(); // TODO: 29.08.2022
                break;
            case "selenoid":
//                manager = new SelenoidMobileWDManager(); // TODO: 29.08.2022
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
