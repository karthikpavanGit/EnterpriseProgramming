import java.sql.*;

public class CallableStatementInOutDemo {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "password");

            // Create callable statement with INOUT parameter
            CallableStatement stmt = con.prepareCall("{call updateEmployeeSalary(?, ?)}");
            stmt.setInt(1, 101);  // Setting IN parameter
            stmt.setFloat(2, 75000);  // Setting INOUT parameter
            stmt.registerOutParameter(2, Types.FLOAT);  // Register OUT parameter

            // Execute stored procedure
            stmt.execute();
            float updatedSalary = stmt.getFloat(2);
            System.out.println("Updated Salary: " + updatedSalary);

            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
