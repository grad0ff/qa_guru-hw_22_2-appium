package tests;

import base.TestBase;
import org.junit.jupiter.api.Test;
import pages.GetStartedPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.back;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class AndroidWikipediaSearchTests extends TestBase {

    GetStartedPage page = new GetStartedPage();

    @Test
    void getStartedPageTest() {
        step("Run app", () ->
                open());
        step("Click by manage languages link", () ->
                page.clickByLanguagesLink());
        step("Check language code is visible", () -> {
            page.languageCode.shouldBe(enabled);
            back();
        });
        step("Click to next page", () ->
                page.clickByForwardButton());
        step("Check primary Text is valid", () ->
                page.primaryTextElement.shouldHave(text("New ways to explore")));
        step("Click to next page", () ->
                page.clickByForwardButton());
        step("Check primary text is valid", () ->
                page.primaryTextElement.shouldHave(text("Reading lists with sync")));
        step("Click to next page", () ->
                page.clickByForwardButton());
        step("Check switch button is checked by default", () ->
                page.toggle.shouldHave(attribute("checked", "true")));
    }
}