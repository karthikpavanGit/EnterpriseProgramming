import java.sql.*;

public class CallableStatementInDemo {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "password");

            // Create callable statement with an IN parameter
            CallableStatement stmt = con.prepareCall("{call getEmployeeDetails(?)}");
            stmt.setInt(1, 101);  // Setting IN parameter
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println("Employee Name: " + rs.getString("name"));
            }

            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
