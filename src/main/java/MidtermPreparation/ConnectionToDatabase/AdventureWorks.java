package MidtermPreparation.ConnectionToDatabase;

import java.sql.*;

class AdventureWorks {
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/adventureworks";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "OOPlab3**";
    private static final String CONNECTION_STRING_2 = "jdbc:mysql://localhost:3306/classicmodels";

    private Connection connection = null;
    private Connection connection1 = null;

    public AdventureWorks () {
        try {
            connection =
                    DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException (e);
        }
        try{
            connection1 =
                    DriverManager.getConnection(CONNECTION_STRING_2, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void productNumberJOINReview() throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement(
                "SELECT pr.ProductNumber, rev.Comments FROM product pr JOIN productreview rev ON pr.ProductID = rev.ProductID"
        );
        ResultSet rs = statement.executeQuery();
        while (rs.next()){
            System.out.println(rs.getString("ProductNumber"));
            //System.out.println(rs.getString("Comments"));
        }
    }
    public void productCROSSJOINReviw() throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement(
                "SELECT pr.ProductNumber, rev.Comments FROM product pr CROSS JOIN productreview rev ON pr.ProductID = rev.ProductID"
        );
        ResultSet rs = statement.executeQuery();

        while(rs.next()) {
            System.out.println(rs.getString("ProductNumber"));
            System.out.println(rs.getString("Comments"));
        }
    }
    public void productNumberLEFTJOINReviews() throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement(
                "SELECT pr.ProductNumber, rev.Comments FROM product pr LEFT JOIN productreview rev ON pr.ProductID = rev.ProductID"
        );
        ResultSet rs = statement.executeQuery();

        while(rs.next()) {
            System.out.println(rs.getString("ProductNumber"));
            System.out.println(rs.getString("Comments"));
        }
    }
    public void productNameLineDescription() throws SQLException {
        PreparedStatement statement = this.connection1.prepareStatement(
                "SELECT p.productName, p.productLine, pl.textDescription FROM products p JOIN productlines pl ON p.productLine = pl.productLine"
        );
        ResultSet rs = statement.executeQuery();

        while(rs.next()) {
            System.out.println(rs.getString("productName"));
            System.out.println(rs.getString("productLine"));
            System.out.println(rs.getString("textDescription"));
        }
    }
    public void productProductInventoryLocation() throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement(
                "SELECT p.Name, p.ProductNumber, pi.Quantity, l.Name " +
                        "FROM product p JOIN productinventory pi ON p.ProductID = pi.ProductID" +
                        " JOIN location l ON pi.LocationID = l.LocationID"
        );
        ResultSet rs = statement.executeQuery();

        while(rs.next()) {
            System.out.println(rs.getString("Name"));
            System.out.println(rs.getString("ProductNumber"));
            System.out.println(rs.getString("Quantity"));
            System.out.println(rs.getString("Name"));
        }
    }
    /*
    SQL SYNTAX ERROR
    public void productProductVendorVendorUnitmeasure() throws SQLException {
            PreparedStatement s = this.connection.prepareStatement(
                "SELECT p.Name, v.Name, pv.UnitMeasureCode, um.Name " +
                        "FEOM product p JOIN productvendor pv ON p.ProductID = pv.ProductID " +
                        "JOIN vendor v ON pv.VendorID = v.VendorID " +
                        "JOIN unitmeasure um ON pv.UnitMeasureCode = um.UnitMeasureCode"
        );
        ResultSet rs = s.executeQuery();

        while (rs.next()){
            System.out.println(rs.getString("Name"));
            System.out.println(rs.getString("Name"));
            System.out.println(rs.getString("UnitMeasureCode"));
            System.out.println(rs.getString("Name"));

        }
    } */
    public void totalForAllOrders() throws SQLException {
        PreparedStatement s = this.connection1.prepareStatement(
                "select o.OrderNumber, od.quantityOrdered*od.priceEach as 'Total' " +
                        ", o.Status from orders o " +
                        "join orderdetails od on o.OrderNumber = od.OrderNumber " +
                        "group by o.Status"
        );
        ResultSet rs = s.executeQuery();

        while(rs.next()) {
            System.out.println(rs.getString("OrderNumber"));
            System.out.println(rs.getString("Total"));
            System.out.println(rs.getString("Status"));
        }
    }

}
class RunQuery{
    public static void main(String[] args) {
        AdventureWorks aw = new AdventureWorks();
        try {
            aw.productNumberJOINReview();
            System.out.println();
            aw.productCROSSJOINReviw();
            System.out.println();
            aw.productNumberLEFTJOINReviews();
            System.out.println();
            aw.productNameLineDescription();
            System.out.println();
            aw.productProductInventoryLocation();
            System.out.println();
            //aw.productProductVendorVendorUnitmeasure();
            aw.totalForAllOrders();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}