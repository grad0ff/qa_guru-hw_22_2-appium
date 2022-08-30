package base;

import com.codeborne.selenide.Configuration;
import config.BrowserstackConfig;
import drivers.BrowserstackMobileDriver;
import helpers.Attach;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class BrowserstackMobileWDManager extends AbstractWDManager {

    static BrowserstackConfig config = ConfigFactory.create(BrowserstackConfig.class);

    @Override
    void configureBeforeAll() {
        Configuration.browser = BrowserstackMobileDriver.class.getName();
        Configuration.browserSize = null;
    }

    @Override
    void configureAfterEach() {
        String sessionId = Attach.getSessionId();
        super.configureAfterEach();
        String videoUrl = getVideoUrl(sessionId);
        Attach.addVideo(videoUrl);
    }

    @Override
    String getVideoUrl(String sessionId) {
        String url = format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);
        return given()
                .auth().basic(config.getUser(), config.getKey())
                .log().all()
                .when()
                .get(url)
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .path("automation_session.video_url");
    }
}
