package pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;

public class GetStartedPage {

    private final SelenideElement forwardButtonElement = $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button"));
    private final SelenideElement languagesLink = $(AppiumBy.id("org.wikipedia.alpha:id/addLangContainer")).lastChild();
    public SelenideElement primaryTextElement = $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"));
    public SelenideElement languageCode = $(AppiumBy.id("org.wikipedia.alpha:id/wiki_language_code"));
    public SelenideElement toggle = $(AppiumBy.id("org.wikipedia.alpha:id/switchView"));

    public void clickByLanguagesLink() {
        languagesLink.click();
    }

    public void clickByForwardButton() {
        forwardButtonElement.click();
    }
}
