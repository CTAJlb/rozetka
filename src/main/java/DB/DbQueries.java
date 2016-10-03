package DB;

import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

/**
 * Created by CTAJlb on 02.10.2016.
 */
public class DbQueries {

    static Logger log = Logger.getLogger(DbQueries.class);

    public static void executeClearTable(Statement st) {
        try {

            st.executeUpdate("DELETE FROM smartphones");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void executeAddProducts(Map<String, Integer> products, Statement st) {
        log.info("Add products map to DB");
        for (Map.Entry<String, Integer> entry : products.entrySet()) {
            try {
                st.executeUpdate("insert into rozetka.smartphones (MODEL, PRICE) values ('"+entry.getKey()+"', "+entry.getValue()+")");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void getReportToFile(Statement st) {
        try {

            st.executeQuery("SELECT \n" +
                    "    'MODEL', 'PRICE(uah)'\n" +
                    "UNION ALL\n" +
                    "SELECT MODEL, PRICE\n" +
                    "FROM\n" +
                    "    smartphones\n" +
                    "INTO OUTFILE 'C:/ProgramData/MySQL/MySQL Server 5.7/Uploads/report.csv' \n" +
                    "\n" +
                    "CHARACTER SET CP1251\n" +
                    "FIELDS ENCLOSED BY '\"'\n" +
                    "TERMINATED BY ';' \n" +
                    "LINES TERMINATED BY '\\r\\n';");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
