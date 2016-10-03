package uiLayer;

import core.Driver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by CTAJlb on 28.09.2016.
 */
public class PhonesPage extends PageFactorySettings {

    static Logger log = Logger.getLogger(PhonesPage.class);

    @FindBy(xpath = "//a[@class='pab-h3-link'][contains(text(), 'Смартфоны')]")
    WebElement smartPhonesLink;

    public void moveToSmartphonesPage(){
        Driver.getWait().until(ExpectedConditions.visibilityOf(smartPhonesLink)).click();
        log.info("Smartphones page open");
    }
}
