package Week3;

import java.sql.*;

public class LectureDbConnect {
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/classicmodels";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "OOPlab3**";

    private Connection connection = null;

    public LectureDbConnect() {
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void getAllCustomers() throws SQLException {
        PreparedStatement statement = this
                .connection
                .prepareStatement("SELECT * FROM customers;");
        ResultSet rs = statement.executeQuery();

        while (rs.next()){
            System.out.println(rs.getString("customerNumber"));
            System.out.println(rs.getString("customerName"));
        }
        System.out.println("\nNEXT METHOD:\n");
    }
    public void getCustomerById(int customerId) throws SQLException {
        PreparedStatement statement = this
                .connection
                .prepareStatement("SELECT * FROM customers WHERE customerNumber = ?");
        statement.setInt(1, customerId);
        ResultSet rs = statement.executeQuery();

        while (rs.next()){
            System.out.println(rs.getString("customerNumber"));
            System.out.println(rs.getString("customerName"));
        }
    }
    // ******** MAIN ********

    public static void main(String[] args) {
        LectureDbConnect dbConnect = new LectureDbConnect();
        try {
            dbConnect.getAllCustomers();
            dbConnect.getCustomerById(471);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
