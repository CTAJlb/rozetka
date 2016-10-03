package uiLayer;

import core.Driver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by CTAJlb on 28.09.2016.
 */
public class PhonesTvElectronicPage extends PageFactorySettings {

    static Logger log = Logger.getLogger(PhonesTvElectronicPage.class);

    @FindBy(xpath = "//a[@class='pab-h3-link'][contains(text(), 'Телефоны')]")
    WebElement phonesLink;

    public void moveToPhonesPage(){
        Driver.getWait().until(ExpectedConditions.visibilityOf(phonesLink)).click();
        log.info("Phones page open");
    }
}
