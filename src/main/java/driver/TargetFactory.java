package driver;


import exceptions.TargetNotValidException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import static config.ConfigurationManager.configuration;


public class TargetFactory {
    private static final Logger logger = LogManager.getLogger(TargetFactory.class);

    public WebDriver createInstance(String browser) {
        Target target = Target.valueOf(configuration().target().toUpperCase());
        WebDriver webdriver;

        switch (target) {
            case LOCAL:
                webdriver = BrowserFactory.valueOf(browser.toUpperCase()).createDriver();
                break;
            default:
                throw new TargetNotValidException(target.toString());
        }
        return webdriver;
    }

    enum Target {
        LOCAL, REMOTE
    }
}
