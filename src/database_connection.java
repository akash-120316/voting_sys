import java.sql.*;
import java.util.Scanner;

class DatabaseOperation {
    protected Connection connect() {
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

    protected void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Closing connection failed: " + e.getMessage());
        }
    }
}


public class database_connection extends DatabaseOperation {


    public void initialise(int id, String name, int phone, int age) {

        Connection conn = connect();
        String query = "INSERT INTO user_infoo (id, name, phone, age) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setInt(3, phone);
            stmt.setInt(4, age);
            stmt.executeUpdate();
            System.out.println("Record inserted successfully.");
        } catch (SQLException e) {
            System.out.println("Error inserting record: " + e.getMessage());
        } finally {
            closeConnection(conn);
        }
    }

    public void update(int id, String name, int phone, int age) {

        Connection conn = connect();
        String query = "UPDATE user_infoo SET name = ?, phone = ?, age = ? WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setInt(2, phone);
            stmt.setInt(3, age);
            stmt.setInt(4, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Record updated successfully.");
            } else {
                System.out.println("Record not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error updating record: " + e.getMessage());
        } finally {
            closeConnection(conn);
        }
    }

    public void display(int id) {
        Connection conn = connect();
        String query = "SELECT * FROM user_infoo WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Phone: " + rs.getInt("phone"));
                System.out.println("Age: " + rs.getInt("age"));
            } else {
                System.out.println("Record not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error displaying record: " + e.getMessage());
        } finally {
            closeConnection(conn);
        }
    }

    public void delete(int id) {
        Connection conn = connect();
        String query = "DELETE FROM user_infoo WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Record deleted successfully.");
            } else {
                System.out.println("Record not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting record: " + e.getMessage());
        } finally {
            closeConnection(conn);
        }
    }

    public static void main(String[] args) {


        database_connection ob = new database_connection();

        Scanner sc = new Scanner(System.in);
        int id;
        int age;
        String name;
        int phone;
        while (true) {


            System.out.println("Enter choice");
            System.out.println("1-initialise");
            System.out.println("2-update");
            System.out.println("3-display");
            System.out.println("4-delete");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the id to register");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the name");
                    name = sc.nextLine();
                    System.out.println("Enter the phone");
                    phone = sc.nextInt();
                    System.out.println("Enter the age");
                    age = sc.nextInt();
                    ob.initialise(id, name, phone, age);
                    break;
                case 2:
                    System.out.println("Enter the id to update");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the name");
                    name = sc.nextLine();
                    System.out.println("Enter the phone");
                    phone = sc.nextInt();
                    System.out.println("Enter the age");
                    age = sc.nextInt();
                    ob.update(id, name, phone, age);
                    break;
                case 3:

                    System.out.println("Enter the id to display");
                    id = sc.nextInt();

                    ob.display(id);
                    break;
                case 4:
                    System.out.println("Enter the id to delete");
                    id = sc.nextInt();

                    ob.delete(id);

                    break;
                case 5:
                    sc.close();
                    break;
                default:
                    System.out.println("Enter valid");
                    break;
            }
        }

    }


}
