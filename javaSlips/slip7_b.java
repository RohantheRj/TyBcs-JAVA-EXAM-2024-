import java.sql.*;

public class ProductTableDemo {

    static final String DB_URL = "jdbc:postgresql://localhost:5432/your_database";
    static final String USER = "username";
    static final String PASS = "password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            if (conn != null) {
                System.out.println("Connected to the PostgreSQL database!");


                insertRecords(conn);


                displayRecords(conn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertRecords(Connection conn) throws SQLException {
        String[] products = {
            "('101', 'Product A', 50.00)",
            "('102', 'Product B', 75.50)",
            "('103', 'Product C', 100.25)",
            "('104', 'Product D', 120.75)",
            "('105', 'Product E', 90.99)"
        };

        String sql = "INSERT INTO Product (Pid, Pname, Price) VALUES ";

        try (Statement stmt = conn.createStatement()) {
            for (String product : products) {
                stmt.addBatch(sql + product);
            }
            stmt.executeBatch();
            System.out.println("Records inserted into Product table!");
        }
    }

    private static void displayRecords(Connection conn) throws SQLException {
        String sql = "SELECT * FROM Product";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("Product Table:");
            System.out.println("===============");
            System.out.println("Pid\tPname\tPrice");
            while (rs.next()) {
                int pid = rs.getInt("Pid");
                String pname = rs.getString("Pname");
                double price = rs.getDouble("Price");
                System.out.println(pid + "\t" + pname + "\t" + price);
            }
        }
    }
}

