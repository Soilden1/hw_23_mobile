package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:browserstack.properties"
})
public interface BrowserstackConfig extends Config {

    @Key("accessKey")
    String getAccessKey();

    @Key("userName")
    String getUserName();

    @Key("device")
    String getDevice();

    @Key("osVersion")
    String getOsVersion();

    @Key("application")
    String getApp();
}
