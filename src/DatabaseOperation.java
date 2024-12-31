import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
class DatabaseOperation {
    public Connection connect() {
        String url = "jdbc:mysql://localhost:3306/voting_base";
        String user = "root";
        String password = "";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
        return conn;
    }
    public void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Closing connection failed: " + e.getMessage());
        }
    }
}
