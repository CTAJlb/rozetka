package uiLayer;

import core.Driver;
import core.PropertyConfig;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/**
 * Created by CTAJlb on 28.09.2016.
 */
public class HomePage extends PageFactorySettings {

    static Logger log = Logger.getLogger(HomePage.class);

    @FindBy(xpath = "//a[contains(text(), 'Телефоны, ТВ и электроника')]")
    WebElement phonesTvElectronicMenuLink;

    public static String getCurrentURL() {
        return Driver.get().getCurrentUrl();
    }

    public static HomePage open() {
        Driver.get().get(PropertyConfig.getProperty("test.homePage"));
        Assert.assertEquals(getCurrentURL(), PropertyConfig.getProperty("test.homePage"), "HomePage URL was not as expected");
        log.info("Home page open");
        return new HomePage();
    }

    public void moveToPhonesTvElectronicPage(){
        phonesTvElectronicMenuLink.click();
        log.info("PhonesTvElectronic page open");
    }
}
