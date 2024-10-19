import java.sql.*;

public class CallableStatementOutDemo {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "password");

            // Create callable statement with an OUT parameter
            CallableStatement stmt = con.prepareCall("{call getEmployeeSalary(?, ?)}");
            stmt.setInt(1, 101);  // Setting IN parameter
            stmt.registerOutParameter(2, Types.FLOAT);  // Register OUT parameter

            // Execute stored procedure
            stmt.execute();
            float salary = stmt.getFloat(2);
            System.out.println("Employee Salary: " + salary);

            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
