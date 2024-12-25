import java.sql.*;
import java.util.Scanner;

public class AddCandidate extends DatabaseOperation {
    public void initialise(int id, String name, int phone, int age,String party_name) {
        Connection conn = connect();
        String query = "INSERT INTO candidate (candidate_id, candidate_name, candidate_age, candidate_phone, party_name) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setInt(3, age);
            stmt.setInt(4, phone);
            stmt.setString(5, party_name);
            stmt.executeUpdate();
            System.out.println("Record inserted successfully.");
        } catch (SQLException e) {
            System.out.println("Error inserting record: " + e.getMessage());
        } finally {
            closeConnection(conn);
        }
    }

    public void update(int id, String name, int phone, int age,String party_name) {
        Connection conn = connect();
        String query = "UPDATE candidate SET candidate_name = ?, candidate_phone = ?, candidate_age = ? ,party_name=? WHERE candidate_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setInt(2, phone);
            stmt.setInt(3, age);
            stmt.setString(4, party_name);
            stmt.setInt(5,id );
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
        String query = "SELECT * FROM candidate WHERE candidate_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("Candidate Id: " + rs.getInt("candidate_id"));
                System.out.println("Candidate Name: " + rs.getString("candidate_name"));
                System.out.println("Candidate Phone: " + rs.getInt("candidate_phone"));
                System.out.println("Candidate Age: " + rs.getInt("candidate_age"));
                System.out.println("Party Name: " + rs.getString("party_name"));
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
        String query = "DELETE FROM candidate WHERE candidate_id = ?";
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
        AddCandidate ob = new AddCandidate();
        Scanner sc = new Scanner(System.in);
        int id;
        int age;
        String name;
        String party_name;
        int phone;
        while (true) {
            System.out.println("Enter choice to manipulate candidate info");
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
                    System.out.println("Enter the party name");
                    sc.nextLine();
                    party_name = sc.nextLine();
                    ob.initialise(id, name, phone, age,party_name);
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
                    System.out.println("Enter the party name");
                    sc.nextLine();
                    party_name = sc.nextLine();
                    ob.update(id, name, phone, age,party_name);
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
