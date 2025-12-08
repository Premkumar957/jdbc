import java.sql.*;

public class App {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/practice";
        String user = "root";
        String password = "root";

        String query = "SELECT id, name, age FROM students";

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getInt("age"));
            }
        } catch (SQLException e) {
            System.out.println("It not work");
            e.printStackTrace();
        }

    }
}
