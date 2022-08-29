package base;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class MainTestBase {

    private static AbstractWDManager manager;

    static {
        String deviceHost = System.getProperty("-DdeviceHost");
        switch (deviceHost) {
            case "emulator":
            case "real":
                manager = new LocalMobileWDManager();
                break;
            case "browserstack":
//                manager = new BrowserstackMobileWDManager(); // TODO: 29.08.2022
                break;
            case "selenoid":
//                manager = new SelenoidMobileWDManager(); // TODO: 29.08.2022
                break;
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
