package extensions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import org.testng.Reporter;
import utilities.CommonOps;

public class DataBaseAction extends CommonOps {

    public static Connection conn = null;
    // Statement object
    public Statement stmt;
    // Result Set
    public ResultSet results = null;
    // Constant for Database URL
    public static String DB_URL = ""; // ORacle
    // "jdbc:oracle:thin:@localhost:1521/sid"

    // Constant for Database Username
    public static String DB_USER = getData("DB_user");
    // Constant for Database Password
    public static String DB_PASSWORD = getData("DB_password");
    // Driver
    public static String driver = getData("DB_driver"); // "oracle.jdbc.driver.OracleDriver"

    public Double executeStatement(String query,String name) {
        Double result = null;

        Properties props = new Properties();
        props.setProperty("user", DB_USER);
        props.setProperty("password", DB_PASSWORD);
        try {
            // STEP 1: Register JDBC driver
            Class.forName(driver).newInstance();

            // STEP 2: Get connection to DB
            System.out.println("\nConnecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            // conn = DriverManager.getConnection(DB_URL, props);
            System.out.println("Connected database successfully...");

            // STEP 3: Statement object to send the SQL statement to the Database
            System.out.println("Creating statement...");
            stmt = conn.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            String SQL = query;

            Statement stmt = conn.createStatement();
            boolean results = stmt.execute(SQL);
            int rsCount = 0;
            // Loop through the available result sets.
            do {
                if (results) {
                    ResultSet rs = stmt.getResultSet();
                    rsCount++;

                    // Show data from the result set.
                    System.out.println("RESULT SET #" + rsCount);
                    while (rs.next()) {
                        result = rs.getDouble("COUNT(*)");
                        System.out.println(rs.getInt("COUNT(*)"));
                    }
                    rs.close();
                }
                Reporter.log(name,true);
                results = stmt.getMoreResults();
            } while (results);
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
