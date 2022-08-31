package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/localdriver.properties")
public interface LocalDriverConfig extends Config {

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
