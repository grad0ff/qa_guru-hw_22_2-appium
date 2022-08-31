package managers;

import com.codeborne.selenide.Selenide;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;

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
        step("Close driver", Selenide::closeWebDriver);
    }

    public void configureAfterAll() {
    }
}
