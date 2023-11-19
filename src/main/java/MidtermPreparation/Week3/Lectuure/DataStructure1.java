package MidtermPreparation.Week3.Lectuure;

import java.sql.*;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

enum Gender {
    MALE, FEMALE
}
class User {
    private String name;
    private Gender gender;
    private int age;

    public User(String name, Gender gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public Gender getGender() {
        return gender;
    }
    public int getAge() {
        return age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setGender(Gender gender){
        this.gender = gender;
    }
    public void setAge(int age) {
        this.age = age;
    }

}
class DataStructure1 {
    private List<User> users;

    public DataStructure1() {
        users = Arrays.asList(
                new User("Amir", Gender.MALE, 28),
                new User("Samira", Gender.FEMALE, 21),
                new User("Amar", Gender.MALE, 16)
        );
    }

    public List<User> getAll() {
        return this.users;
    }

    public Optional<User> getByName (String name) {
        return users
                .stream()
                .filter(user -> {
                    return user.getName().equals(name);
                }).findFirst();
    }
    public List<User> findAgeGreaterThan(int age) {
        return users
                .stream()
                .filter (user -> age >= user.getAge())
                .toList();
    }
    public void getBYGender (Gender gender) {
        users = users.stream()
                .filter(user -> user.getGender().equals(gender))
                .collect(Collectors.toList());
        for (User user : users) {
            System.out.println(user.getName());
        }
    }
}
class DbConnect1 {
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/classicmodels";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "OOPlad3**";

    Connection connection = null;

    public DbConnect1() {
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void getAllCustomers() throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement ("SELECT * FROM customers LIMIT 5");
        ResultSet rs = statement.executeQuery();

        while (rs.next()){
            System.out.println(rs.getString(("customerName")));
            System.out.println(rs.getString("customerNumber"));
        }
    }
    public void getCustomerById(int customerId) throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement (
                "SELECT * FROM customers WHERE customerId = ?"
        );
        statement.setInt(1, customerId);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getString("customerNumber"));
            System.out.println(rs.getString("customerName"));
        }
    }
}









