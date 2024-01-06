package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.BrowserstackConfig;
import config.LocalConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {

    protected static BrowserstackConfig browserstackConfig = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());
    protected static LocalConfig localConfig = ConfigFactory.create(LocalConfig.class, System.getProperties());

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {

        MutableCapabilities caps = new MutableCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", browserstackConfig.getUserName());
        caps.setCapability("browserstack.key", browserstackConfig.getAccessKey());

        // Set URL of the application under test
        caps.setCapability("app", browserstackConfig.getApp());

        // Specify device and os_version for testing
        caps.setCapability("device", browserstackConfig.getDevice());
        caps.setCapability("os_version", browserstackConfig.getOsVersion());

        // Set other BrowserStack capabilities
        caps.setCapability("project", localConfig.getProject());
        caps.setCapability("build", localConfig.getBuild());
        caps.setCapability("name", localConfig.getName());

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        try {
            return new RemoteWebDriver(
                    new URL("https://hub.browserstack.com/wd/hub"), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
