package pages;

import driver.DriverManager;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import static config.ConfigurationManager.configuration;

public class Base {
    protected Base() {
        PageFactory.initElements(new AjaxElementLocatorFactory(DriverManager.getDriver(), configuration().timeout()), this);
    }
}
