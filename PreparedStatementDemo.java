import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PreparedStatementDemo {
    public static void main(String[] args) {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "password");

            // Create prepared statement for inserting data
            String query = "INSERT INTO employees (id, name, salary) VALUES (?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(query);

            // Set parameters
            pstmt.setInt(1, 102);
            pstmt.setString(2, "Alice");
            pstmt.setFloat(3, 70000);

            // Execute the query
            int rowsInserted = pstmt.executeUpdate();
            System.out.println("Rows inserted: " + rowsInserted);

            // Close the connection
            pstmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
