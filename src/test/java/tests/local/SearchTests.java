package tests.local;

import base.MainTestBase;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("android")
public class SearchTests extends MainTestBase {

    @Test
    void getStartedPageTest() {
        SelenideElement forwardButtonElement = $(AppiumBy.id("org.wikipedia:id/fragment_onboarding_forward_button"));
        SelenideElement primaryTextElement = $(AppiumBy.id("org.wikipedia:id/primaryTextView"));

        step("Run app", () ->
                open());
        step("Click by manage languages link", () ->
                $(AppiumBy.id("org.wikipedia:id/addLangContainer")).lastChild().click());
        step("Check language code is visible", () -> {
            $(AppiumBy.id("org.wikipedia:id/wiki_language_code")).shouldBe(enabled);
            back();
        });
        step("Click to next page", () ->
                forwardButtonElement.click());
        step("Check primary Text is valid", () ->
                primaryTextElement.shouldHave(text("Новые способы исследований")));
        step("Click to next page", () ->
                forwardButtonElement.click());
        step("Check primary text is valid", () ->
                primaryTextElement.shouldHave(text("Списки для чтения с синхронизацией")));
        step("Click to next page", () ->
                forwardButtonElement.click());
        step("Check switch button is checked by default", () ->
                $(AppiumBy.id("org.wikipedia:id/switchView")).shouldHave(attribute("checked", "true")));
    }

    @Test
    void searchTest() {
        step("Run app", () ->
                open());
        step("Type search", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/search_container")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });
        step("Verify content found", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(CollectionCondition.sizeGreaterThan(0)));
    }

    @Test
    void searchWithByTextLocatorTest() {
        step("Run app", () ->
                open());
        switchTo().alert().accept();
        step("Type search", () -> {
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });
        step("Verify content found", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(CollectionCondition.sizeGreaterThan(0)));
    }
}