package uiLayer;

import core.Driver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by CTAJlb on 28.09.2016.
 */
public class SmartphonesPage extends PageFactorySettings {

    static Logger log = Logger.getLogger(SmartphonesPage.class);

    @FindBy(xpath = "//i[contains(@class,'popularity')]/../a/img[@title]")
    private List<WebElement> topSalesPhoneTitle;

    @FindBy(xpath = "//i[contains(@class,'popularity')]/../../..//div[@class='g-price-uah']")
    private List<WebElement> topSalesphonePrice;


    public Map<String, Integer> getNameAndPhonePriceMap(int pageNum) {

        Map<String, Integer> phoneMap = new HashMap<String, Integer>();
        for (int i = 1; i <= pageNum; i++) {

            log.info("current page " + (i) + ", found topSalesPhones - " + topSalesPhoneTitle.size());

            Iterator<WebElement> phonesTitle = topSalesPhoneTitle.iterator();
            Iterator<WebElement> phonesPrice = topSalesphonePrice.iterator();

                while (phonesTitle.hasNext()) {
                    Driver.getWait().until(ExpectedConditions.visibilityOfAllElements(topSalesPhoneTitle));
                    String phoneTitle = phonesTitle.next().getAttribute("title");
                    int phonePrice = Integer.parseInt(phonesPrice.next().getText().replaceAll("[^0-9]", ""));
                    phoneMap.put(phoneTitle, phonePrice);
                }

                Driver.get().findElement(By.xpath("//li[@id='page" + (i + 1) + "']")).click();

        }
        log.info("All map: " + phoneMap);
        return phoneMap;
    }
}
