package Week3;

import java.sql.*;

public class LabDbConnect {
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/lab3";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "OOPlab3**";

    private Connection connection = null;

    public LabDbConnect() {
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void getAll() throws SQLException {
        PreparedStatement statement = this
                .connection
                .prepareStatement("SELECT * FROM tasks;");
        ResultSet rs = statement.executeQuery();

        System.out.println("Get all objects: ");

        while (rs.next()) {
            System.out.println(rs.getString("id"));
            System.out.println(rs.getString("task_description"));
            System.out.println(rs.getString("task_status"));
        }
    }
    public void getByStatus (Status status) throws SQLException {
        PreparedStatement statement = this
                .connection
                .prepareStatement("SELECT * FROM tasks WHERE task_status = ?");
        statement.setString(1, status.toString());
        ResultSet rs = statement.executeQuery();

        System.out.println("\nGet by status:");

        while (rs.next()) {
            int taskId = rs.getInt("id");
            String taskDescription = rs.getString("task_description");
            String taskStatus = rs.getString("task_status");

            System.out.println(taskId);
            System.out.println(taskDescription);
            System.out.println(taskStatus);
        }
    }
    public void idGreaterThanTwo() throws SQLException {
        PreparedStatement statement = this
                .connection
                .prepareStatement("SELECT * FROM tasks WHERE id >= 2");
        ResultSet rs = statement.executeQuery();

        System.out.println("\nTasks which id is greater or equal to 2:");

        while (rs.next()) {
            System.out.println(rs.getString("id"));
            System.out.println(rs.getString("task_description"));
            System.out.println(rs.getString("task_status"));
        }
    }
    public void printTaskDescription() throws SQLException {
        PreparedStatement statement = this
                .connection
                .prepareStatement("SELECT task_description FROM tasks");
        ResultSet rs = statement.executeQuery();

        System.out.println("\nPrint task description:");

        while (rs.next()) {
            System.out.println(rs.getString("task_description"));
        }
    }

    //******** MAIN **********

}
