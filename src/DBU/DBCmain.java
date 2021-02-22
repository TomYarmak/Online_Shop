package DBU;

import java.sql.*;

public class DBCmain {


    public static void main(String[] args) throws SQLException {
        Connection con = null;
        try {
            //JDBC statements body()
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CASH_MANAGEMENT",
                    "root", "Liliia12091994");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT name, charge FROM merchant");
            while (rs.next()) {
                String nm = rs.getString("name");
                double p = rs.getDouble(2);
                System.out.println(nm + "" + p);
            }
        } catch (SQLException ex) {
            System.out.println("Error" + ex.getMessage());
        } finally {
            if (con != null) {
                con.close(); //connection must be closed
            }
        }
    }
}

