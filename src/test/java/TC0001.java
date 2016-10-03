import DB.DbQueries;
import core.BaseTestSettings;
import core.DbConfig;
import org.testng.annotations.Test;
import uiLayer.HomePage;
import uiLayer.PhonesPage;
import uiLayer.PhonesTvElectronicPage;
import uiLayer.SmartphonesPage;

import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by CTAJlb on 28.09.2016.
 */
public class TC0001 extends BaseTestSettings {

    HomePage homePage;
    PhonesTvElectronicPage phonesTvElectronicPage;
    PhonesPage phonesPage;
    SmartphonesPage smartphonesPage;

    @Test
    public void getAllTopSmartphonePrices() {

        homePage = new HomePage();
        phonesTvElectronicPage = new PhonesTvElectronicPage();
        phonesPage = new PhonesPage();
        smartphonesPage = new SmartphonesPage();

        HomePage.open();
        homePage.moveToPhonesTvElectronicPage();
        phonesTvElectronicPage.moveToPhonesPage();
        phonesPage.moveToSmartphonesPage();

        Connection con = DbConfig.initConnection();
        Statement st = DbConfig.getStatement(con);
        DbQueries.executeClearTable(st);
        DbQueries.executeAddProducts(smartphonesPage.getNameAndPhonePriceMap(3), st);
        DbQueries.getReportToFile(st);
        DbConfig.closeConnection(con, st);

    }
}
