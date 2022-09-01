package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/selenoid.properties")
public interface SelenoidWebDriverConfig extends Config{

    @Key("serverUrl")
    String getServerUrl();

    @Key("login")
    String getLogin();

    @Key("password")
    String getPassword();

    @Key("browserName")
    String getBrowserName();

    @Key("browserVersion")
    String getBrowserVersion();

}
