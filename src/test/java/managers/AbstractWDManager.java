package managers;

import com.codeborne.selenide.Selenide;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.remote.RemoteWebDriver;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static io.qameta.allure.Allure.step;

public abstract class AbstractWDManager {

    public abstract void configureBeforeAll();

    public void configureBeforeEach() {
        addListener("AllureSelenide", new AllureSelenide());
    }

    public void configureAfterEach() {
        Attach.addScreenshotAs("Last screenshot");
        Attach.addPageSource();
        Selenide.closeWebDriver();
    }

    public void configureAfterAll() {
    }

    public String getSessionId() {
        return ((RemoteWebDriver) getWebDriver()).getSessionId().toString();
    }
}
