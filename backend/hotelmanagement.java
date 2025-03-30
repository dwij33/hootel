import java.sql.*;
import java.util.Scanner;

public class HotelManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management", "root", "password");
            Statement stmt = conn.createStatement();
            
            while (true) {
                System.out.println("1. Book a Room\n2. Order Food\n3. Exit");
                int choice = scanner.nextInt();
                scanner.nextLine(); 
                
                if (choice == 1) {
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Room Type (Luxury/Deluxe): ");
                    String roomType = scanner.nextLine();
                    
                    String query = "SELECT id FROM rooms WHERE room_type='" + roomType + "' LIMIT 1";
                    ResultSet rs = stmt.executeQuery(query);
                    if (rs.next()) {
                        int roomId = rs.getInt("id");
                        stmt.executeUpdate("INSERT INTO customers (name, room_id) VALUES ('" + name + "', " + roomId + ")");
                        System.out.println("Room booked successfully!");
                    } else {
                        System.out.println("Room not available.");
                    }
                } else if (choice == 2) {
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Food Item: ");
                    String foodItem = scanner.nextLine();
                    
                    String query = "SELECT id FROM menu WHERE item_name='" + foodItem + "' LIMIT 1";
                    ResultSet rs = stmt.executeQuery(query);
                    if (rs.next()) {
                        int itemId = rs.getInt("id");
                        stmt.executeUpdate("INSERT INTO orders (customer_id, item_id) VALUES ((SELECT id FROM customers WHERE name='" + name + "' LIMIT 1), " + itemId + ")");
                        System.out.println("Order placed successfully!");
                    } else {
                        System.out.println("Item not available.");
                    }
                } else {
                    System.out.println("Exiting...");
                    break;
                }
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        scanner.close();
    }
}
