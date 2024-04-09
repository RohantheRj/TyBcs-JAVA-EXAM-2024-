import java.sql.*;

public class ScrollableResultSetExample {

    public static void main(String[] args) {
        try {

            String url = "jdbc:postgresql://localhost:5432/your_database";
            String username = "your_username";
            String password = "your_password";

            Connection conn = DriverManager.getConnection(url, username, password);


            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);


            String query = "SELECT * FROM Teacher";
            ResultSet rs = stmt.executeQuery(query);


            if (!rs.isBeforeFirst()) {
                System.out.println("ResultSet is not scrollable.");
            } else {

                rs.last();


                System.out.println("Teacher Details (in reverse order):");
                System.out.println("==================================");
                do {
                    int tid = rs.getInt("TID");
                    String tname = rs.getString("TName");
                    double salary = rs.getDouble("Salary");

                    System.out.println("TID: " + tid + ", TName: " + tname + ", Salary: " + salary);
                } while (rs.previous());
            }


            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

