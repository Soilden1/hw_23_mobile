package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:localDevice.properties"
})
public interface LocalConfig extends Config{

    @Key("project")
    String getProject();

    @Key("build")
    String getBuild();

    @Key("name")
    String getName();
}
