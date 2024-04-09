import java.sql.*;
import java.util.Scanner;

public class EmployeeManagement {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/your_database_name";
    private static final String DB_USER = "your_username";
    private static final String DB_PASSWORD = "your_password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            System.out.println("Connected to database.");

            createEmployeeTable(conn);

            Scanner scanner = new Scanner(System.in);
            int choice;
            do {
                System.out.println("\nMenu:");
                System.out.println("1. Insert");
                System.out.println("2. Update");
                System.out.println("3. Display");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        insertEmployee(conn, scanner);
                        break;
                    case 2:
                        updateEmployee(conn, scanner);
                        break;
                    case 3:
                        displayEmployees(conn);
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 4);

            scanner.close();
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void createEmployeeTable(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            String createTableSQL = "CREATE TABLE IF NOT EXISTS Employee (" +
                                    "ENo SERIAL PRIMARY KEY," +
                                    "EName VARCHAR(255) NOT NULL," +
                                    "Salary FLOAT NOT NULL)";
            stmt.executeUpdate(createTableSQL);
            System.out.println("Employee table created or already exists.");
        }
    }

    private static void insertEmployee(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter Employee Name: ");
        String eName = scanner.nextLine();

        System.out.print("Enter Salary: ");
        float salary = scanner.nextFloat();
        scanner.nextLine(); // Consume newline

        String insertSQL = "INSERT INTO Employee (EName, Salary) VALUES (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            pstmt.setString(1, eName);
            pstmt.setFloat(2, salary);
            pstmt.executeUpdate();
            System.out.println("Employee inserted successfully.");
        }
    }

    private static void updateEmployee(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter Employee Number to update: ");
        int eNo = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter new Employee Name: ");
        String eName = scanner.nextLine();

        System.out.print("Enter new Salary: ");
        float salary = scanner.nextFloat();
        scanner.nextLine(); // Consume newline

        String updateSQL = "UPDATE Employee SET EName = ?, Salary = ? WHERE ENo = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {
            pstmt.setString(1, eName);
            pstmt.setFloat(2, salary);
            pstmt.setInt(3, eNo);
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Employee updated successfully.");
            } else {
                System.out.println("Employee with ENo " + eNo + " not found.");
            }
        }
    }

    private static void displayEmployees(Connection conn) throws SQLException {
        String selectSQL = "SELECT * FROM Employee";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(selectSQL)) {
            System.out.println("Employee Table:");
            System.out.println("ENo\tEName\tSalary");
            while (rs.next()) {
                int eNo = rs.getInt("ENo");
                String eName = rs.getString("EName");
                float salary = rs.getFloat("Salary");
                System.out.println(eNo + "\t" + eName + "\t" + salary);
            }
        }
    }
}

