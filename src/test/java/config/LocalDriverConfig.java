package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/local_driver.properties")
public interface LocalDriverConfig extends Config {

    @Key("user")
    String getUser();

    @Key("key")
    String getKey();

    @Key("serverUrl")
    String getServerUrl();

    @Key("realDevice")
    String getRealDevice();

    @Key("realDeviceOs")
    String getRealDeviceOs();

    @Key("emulatorDevice")
    String getEmulatorDevice();

    @Key("emulatorDeviceOs")
    String getEmulatorDeviceOs();


}
