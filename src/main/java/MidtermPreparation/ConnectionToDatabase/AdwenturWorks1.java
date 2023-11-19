package MidtermPreparation.ConnectionToDatabase;

import java.sql.*;

class AdventureWorks1{
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/classicmodels";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "OOPlab3**";

    private Connection connection = null;

    public AdventureWorks1 () {
        try {
            connection =
                    DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void customers() throws SQLException {
        PreparedStatement s = this.connection.prepareStatement(
                "select country, city, max(creditLimit) as 'Max', min(creditLimit) as 'Min' " +
                        ", avg(creditLimit) as 'Average' from customers " +
                        "where country is not null and city is not null " +
                        "group by country, city " +
                        "order by country desc, city asc"
        );
        ResultSet rs = s.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getString("country"));
            System.out.println(rs.getString("city"));
            System.out.println(rs.getString("Max"));
            System.out.println(rs.getString("Min"));
            System.out.println(rs.getString("Average"));
        }
    }
}
class RunAdventureWorks {
    public static void main(String[] args) {
        AdventureWorks1 aw1 = new AdventureWorks1();

        try {
            aw1.customers();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
