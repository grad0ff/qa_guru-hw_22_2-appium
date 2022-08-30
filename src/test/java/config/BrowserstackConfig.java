package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/browserstack.properties")
public interface BrowserstackConfig extends Config {

    @Key("user")
    String getUser();

    @Key("key")
    String getKey();
}
