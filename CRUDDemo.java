import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class CRUDDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "password");
            Statement stmt = con.createStatement();
            
            while (true) {
                System.out.println("CRUD Operations: ");
                System.out.println("1. Create");
                System.out.println("2. Read");
                System.out.println("3. Update");
                System.out.println("4. Delete");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("Enter employee id: ");
                        int id = scanner.nextInt();
                        System.out.print("Enter employee name: ");
                        String name = scanner.next();
                        PreparedStatement insertStmt = con.prepareStatement("INSERT INTO employees (id, name) VALUES (?, ?)");
                        insertStmt.setInt(1, id);
                        insertStmt.setString(2, name);
                        insertStmt.executeUpdate();
                        System.out.println("Employee inserted successfully.");
                        break;
                    case 2:
                        ResultSet rs = stmt.executeQuery("SELECT * FROM employees");
                        while (rs.next()) {
                            System.out.println("ID: " + rs.getInt(1) + ", Name: " + rs.getString(2));
                        }
                        break;
                    case 3:
                        System.out.print("Enter employee id to update: ");
                        int updateId = scanner.nextInt();
                        System.out.print("Enter new name: ");
                        String newName = scanner.next();
                        PreparedStatement updateStmt = con.prepareStatement("UPDATE employees SET name=? WHERE id=?");
                        updateStmt.setString(1, newName);
                        updateStmt.setInt(2, updateId);
                        updateStmt.executeUpdate();
                        System.out.println("Employee updated successfully.");
                        break;
                    case 4:
                        System.out.print("Enter employee id to delete: ");
                        int deleteId = scanner.nextInt();
                        PreparedStatement deleteStmt = con.prepareStatement("DELETE FROM employees WHERE id=?");
                        deleteStmt.setInt(1, deleteId);
                        deleteStmt.executeUpdate();
                        System.out.println("Employee deleted successfully.");
                        break;
                    case 5:
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
