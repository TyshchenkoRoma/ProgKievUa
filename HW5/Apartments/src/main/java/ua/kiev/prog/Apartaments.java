package ua.kiev.prog;

import java.sql.*;
import java.util.Scanner;

/**
 * Спроектировать базу «Квартиры». Каждая запись
 * в базе содержит данные о квартире (район,
 * адрес, площадь, кол. комнат, цена). Сделать
 * возможность выборки квартир из списка по
 * параметрам.
 */
public class Apartaments {
    static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/ApartDB";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "root";

    static Connection conn;

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        try {
            conn = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            while (true) {
                System.out.println("1: Show all apartments");
                System.out.println("2: Show apartments for numbers room");
                System.out.println("3: Show apartments for increase price");
                System.out.println("4: Show apartments for recession price");
                System.out.print("-> ");

                String s = sc.nextLine();
                switch (s) {
                    case "1":
                        getAllApartments();
                        break;
                    case "2":
                        getApartmentsForRoomNumber();
                        break;
                    case "3":
                        getApartmentsForIncreasePrice();
                        break;
                    case "4":
                        getApartmentsForRecessionPrice();
                        break;
                    default:
                        return;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (conn != null) conn.close();
        }
    }

    private static void getApartmentsForRoomNumber() throws SQLException {
        System.out.print("Select number of room from 1 to 4");
        System.out.print("-> ");
        Scanner sc = new Scanner(System.in);
        int s = Integer.parseInt(sc.nextLine());
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM apartament WHERE  room_number = ? ");
        try {
            ps.setInt(1, s);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String dst = rs.getString("district");
                String address = rs.getString("address");
                double area = rs.getInt("area");
                int room_number = rs.getInt("room_number");
                int price = rs.getInt("price");
                System.out.println("Apartment № " + id + "\n District is: " + dst + " Address is: " + address + " Area is: " + area
                        + " Room_number is: " + room_number + " PRICE: " + price);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ps.close();
        }
    }

    private static void getAllApartments() throws SQLException {
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM apartament");
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String dst = rs.getString("district");
                String address = rs.getString("address");
                double area = rs.getInt("area");
                int room_number = rs.getInt("room_number");
                int price = rs.getInt("price");

                System.out.println("Apartment № " + id + "\n District is: " + dst + " Address is: " + address + " Area is: " + area
                        + " Room_number is: " + room_number + " PRICE: " + price);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            st.close();
        }
    }

    private static void getApartmentsForIncreasePrice() throws SQLException {
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM apartament ORDER BY price");
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String dst = rs.getString("district");
                String address = rs.getString("address");
                double area = rs.getInt("area");
                int room_number = rs.getInt("room_number");
                int price = rs.getInt("price");

                System.out.println("Apartment № " + id + "\n District is: " + dst + " Address is: " + address + " Area is: " + area
                        + " Room_number is: " + room_number + " PRICE: " + price);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            st.close();
        }
    }

    private static void getApartmentsForRecessionPrice() throws SQLException {
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM apartament ORDER BY price DESC");
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String dst = rs.getString("district");
                String address = rs.getString("address");
                double area = rs.getInt("area");
                int room_number = rs.getInt("room_number");
                int price = rs.getInt("price");

                System.out.println("Apartment № " + id + "\n District is: " + dst + " Address is: " + address
                        + " Area is: " + area+ " Room_number is: " + room_number + " PRICE: " + price);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            st.close();
        }
    }
}
