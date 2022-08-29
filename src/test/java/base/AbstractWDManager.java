package base;

import com.codeborne.selenide.Selenide;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static io.qameta.allure.Allure.step;

public abstract class AbstractWDManager {

    protected abstract void configureBeforeAll();

    protected void configureBeforeEach() {
        addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    protected void configureAfterEach() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        step("Close driver", Selenide::closeWebDriver);
    }

    protected void configureAfterAll() {
    }
}
