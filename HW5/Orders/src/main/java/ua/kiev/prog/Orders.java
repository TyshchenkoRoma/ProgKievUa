package ua.kiev.prog;


import java.sql.*;
import java.util.Scanner;

/**
 * Создать проект «База данных заказов». Создать
 * таблицы «Товары» , «Клиенты» и «Заказы».
 * Написать код для добавления новых клиентов,
 * товаров и оформления заказов.
 */
public class Orders {
    static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/Orders";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "root";

    static Connection conn;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            try {
                // create connection
                conn = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
                //   init();

                while (true) {
                    System.out.println("1: add product");
                    System.out.println("2: add client");
                    System.out.println("3: create order");
                    System.out.println("4: show created orders");
                    System.out.print("-> ");
                    String s = sc.nextLine();

                    switch (s) {
                        case "1":
                            addProduct(sc);
                            break;
                        case "2":
                            addClient(sc);
                            break;
                        case "3":
                            createOrder(sc);
                            break;
                        case "4":
                            getOrders(sc);
                            break;
                        default:
                            return;
                    }
                }
            } finally {
                sc.close();
                if (conn != null) conn.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return;
        }
    }

    private static void init() throws SQLException {

        java.sql.Statement st = conn.createStatement();
        try {
            st.execute("CREATE TABLE `product` (`id` BIGINT(10) NOT NULL AUTO_INCREMENT,\n" +
                    "                       `name` VARCHAR(25) DEFAULT NULL,\n" +
                    "                       `price` DECIMAL(15) NOT NULL,\n" + "  PRIMARY KEY (`id`));");
            st.execute("CREATE TABLE `product` (`id` BIGINT(10) NOT NULL AUTO_INCREMENT,\n" +
                    "                       `name` VARCHAR(25) DEFAULT NULL,\n" +
                    "                       `price` DECIMAL(15) NOT NULL,\n" +
                    "  PRIMARY KEY (`id`));");
            st.execute("CREATE TABLE `order1` (`id` BIGINT(10) NOT NULL AUTO_INCREMENT,`product_id` VARCHAR(25) DEFAULT NULL, " +
                    " `client_id` VARCHAR(50) NOT NULL, `number1` INTEGER(4) NOT NULL,`total_price` DECIMAL(15) NOT NULL, PRIMARY KEY (`id`))");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private static void addProduct(Scanner sc) throws SQLException {
        System.out.print("Enter product name: ");
        String name = sc.nextLine();
        System.out.print("Enter products price: ");
        String sPrice = sc.nextLine();
        int price = Integer.parseInt(sPrice);
        java.sql.Statement st = conn.createStatement();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO product (name, price) VALUES(?, ?)");
        try {
            ps.setString(1, name);
            ps.setInt(2, price);
            ps.executeUpdate(); // for INSERT, UPDATE & DELETE
        } finally {
            ps.close();
        }
    }

    private static void addClient(Scanner sc) throws SQLException {
        System.out.print("Enter first name: ");
        String firstName = sc.nextLine();
        System.out.print("Enter second name: ");
        String secondName = sc.nextLine();
        System.out.print("Enter age: ");
        String sAge = sc.nextLine();
        int age = Integer.parseInt(sAge);
        java.sql.Statement st = conn.createStatement();

        PreparedStatement ps = conn.prepareStatement("INSERT INTO client (first_name, second_name, age) VALUES(?, ?, ?)");
        try {
            ps.setString(1, firstName);
            ps.setString(2, secondName);
            ps.setInt(3, age);
            ps.executeUpdate(); // for INSERT, UPDATE & DELETE
        } finally {
            ps.close();
        }
    }

    private static void createOrder(Scanner sc) throws SQLException {
        int idProd = selectIdProduct(sc);
        System.out.print("Enter number OF Products: ");
        int num = sc.nextInt();
        int idClie = selectClient(sc);
        String selectedProdName = getProductNameFromId(idProd);
        String selectedClientName = getClientNameFromId(idClie);
        System.out.println("WE HAVE  product name : " + selectedProdName);
        System.out.println("WE HAVE  client name : " + selectedClientName);
        sc.nextLine();

        PreparedStatement ps = conn.prepareStatement("INSERT INTO order1 (product_id, client_id, number1, total_price) VALUES(?, ?, ?, ?)");
        try {
            ps.setString(1, selectedProdName);
            ps.setString(2, selectedClientName);
            ps.setInt(3, num);
            ps.setInt(4, getTotalPrice(num, selectedProdName));
            ps.executeUpdate(); // for INSERT, UPDATE & DELETE
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ps.close();
        }
    }

    private static int selectIdProduct(Scanner sc) throws SQLException {
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM product");
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getInt("price");
                System.out.println("ID № " + id + "\n Name is: " + name + " Price is: " + price);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            st.close();
        }
        System.out.println("Input id selected product");
        int idProduct = sc.nextInt();
        return idProduct;
    }

    private static int selectClient(Scanner sc) throws SQLException {
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM client");
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String secondName = rs.getString("second_name");
                double age = rs.getInt("age");
                System.out.println("ID № " + id + "\n FirstName is: " + firstName + " SecondName is: " + secondName +
                        " Age is: " + age);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            st.close();
        }
        System.out.println("Input id selected client");
        int idClient = sc.nextInt();
        return idClient;
    }


    private static String getProductNameFromId(int id_prod) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("SELECT name FROM product WHERE id = ?");
        try {
            ps.setInt(1, id_prod);
            ResultSet rs = ps.executeQuery();
            rs.next();
            String prodName = rs.getString("name");
            return prodName;
        } finally {
            ps.close();
        }
    }

    private static String getClientNameFromId(int id) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("SELECT first_name FROM client WHERE id = ?");
        try {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            String clientName = rs.getString("first_name");
            return clientName;
        } finally {
            ps.close();
        }
    }

    private static void getOrders(Scanner sc) throws SQLException {
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM order1");
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String prod = rs.getString("product_id");
                String clnt = rs.getString("client_id");
                int numb = rs.getInt("number1");
                int priceTot = rs.getInt("total_price");
                System.out.println("Order № " + id + "\n Product name is: " + prod + " Client is: " + clnt + " Number of products is: "
                        + numb + " Total price is: " + priceTot);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            st.close();
        }
    }

    private static int getTotalPrice(int price, String productName) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("SELECT price FROM product WHERE name =?");
        try {
            ps.setString(1, productName);
            ResultSet rs = ps.executeQuery();
            rs.next();
            int totalPrice = rs.getInt("price");
            return totalPrice * price;
        } finally {
            ps.close();
        }
    }
}

