
package controller;



import java.sql.*;


public class ConnectDB {
    protected Connection conn;

    public ConnectDB() {

try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String url = "jdbc:sqlserver://localhost:1433; databaseName=He_Thong_Truong_Mam_Non;encrypt=true;trustServerCertificate=true";
            String username = "sa";
            String password = "sa";

            conn = DriverManager.getConnection(url, username, password);
         //   System.out.println("Database connected");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


//    public static void main(String[] args) {
//        new ConnectDB();
//    }

    public PreparedStatement prepareStatement(String query) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
