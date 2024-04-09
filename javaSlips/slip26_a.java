import java.sql.*;

public class DeleteEmployee {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java DeleteEmployee <EmployeeID>");
            return;
        }

        int employeeId = Integer.parseInt(args[0]);

        String url = "jdbc:postgresql://localhost:5432/your_database_name";
        String username = "your_username";
        String password = "your_password";

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DriverManager.getConnection(url, username, password);

            String sql = "DELETE FROM Employee WHERE ENo = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, employeeId);

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Employee with ID " + employeeId + " deleted successfully.");
            } else {
                System.out.println("Employee with ID " + employeeId + " not found.");
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }
}

