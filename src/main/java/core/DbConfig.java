package core;

import java.sql.*;

/**
 * Created by CTAJlb on 30.09.2016.
 */
public class DbConfig {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/rozetka?autoReconnect=true&useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    public static Connection connection;
    public static Statement statement;

    public static Connection initConnection() {
        try {

            connection = DriverManager.getConnection(URL, USER,
                    PASSWORD);
            return connection;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    public static Statement getStatement(Connection con) {
        try {

            statement = con.createStatement();

        } catch (Exception e ) {
            e.printStackTrace();
        }
        return statement;
    }


    public static void closeConnection(Connection con, Statement st) {
        try {

            if (con != null) {
                con.close();

            }
            if (st != null) {
                st.close();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
