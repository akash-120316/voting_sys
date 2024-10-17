//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//
//public class DatabaseOperation {
//
//
//
//    class DatabaseOperations {
//        public Connection connect() {
//            String url = "jdbc:mysql://localhost:3306/voting_base";
//            String user = "root";  // replace with your database user
//            String password = "pUBGraa@2708";  // replace with your database password
//
//            Connection conn = null;
//            try {
//                conn = DriverManager.getConnection(url, user, password);
//            } catch (SQLException e) {
//                System.out.println("Connection failed: " + e.getMessage());
//            }
//            return conn;
//        }
//
//        public void closeConnection(Connection conn) {
//            try {
//                if (conn != null) {
//                    conn.close();
//                }
//            } catch (SQLException e) {
//                System.out.println("Closing connection failed: " + e.getMessage());
//            }
//        }
//    }
//
//}
