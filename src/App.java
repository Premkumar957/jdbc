//Step 1: Import the package
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.CallableStatement;
import java.sql.ResultSet;

public class App {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://127.0.0.1:3306/practice";
        String user = "root";
        String password = "root";

          
        //Step 2: Load and register the Driver (optional)
        Class.forName("com.mysql.cj.jdbc.Driver");

        //Step 3: Establish Connection
        Connection con = DriverManager.getConnection(url,user, password);

        //Step 4: Create a Statement || PreparedStatement || CallableStatement
        String city = "Chennai";
        CallableStatement cs = con.prepareCall("{call getSameCityCustomers(?)}");
        cs.setString(1, city);

        

        //Step 5: Execute the statment/Sql Query
        ResultSet rs = cs.executeQuery();

        
        
    
       

        // // Step 6: Process the results
        while (rs.next()) {
            System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getString("city") + " "  + rs.getInt("pincode"));
        }

        //Step 7: Close the connection
        rs.close();
        cs.close();
        con.close();



    }
}
