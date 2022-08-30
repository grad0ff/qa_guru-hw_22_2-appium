package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import drivers.LocalMobileDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static io.qameta.allure.Allure.step;

public abstract class AbstractWDManager {

    abstract void configureBeforeAll();

    void configureBeforeEach() {
        addListener("AllureSelenide", new AllureSelenide());
    }

    void configureAfterEach() {
        Attach.addScreenshotAs("Last screenshot");
        Attach.addPageSource();
        step("Close driver", Selenide::closeWebDriver);
    }

    void configureAfterAll() {
    }

    abstract String getVideoUrl(String sessionId); // TODO: 30.08.2 реализовать отдельно (независимо) в классах
}
