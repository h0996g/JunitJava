package DAO;

import com.company.DeliveryGuy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class DeliveryGuyDAOTest {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE";
        String username = "Delivery";
        String password = "12";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            // Create an instance of DeliveryGuyDAO
            DeliveryGuyDAO deliveryGuyDAO = new DeliveryGuyDAO(connection);

            // Test insert
//            DeliveryGuy newDeliveryGuy = new DeliveryGuy(/* your parameters */);
//            deliveryGuyDAO.insert(newDeliveryGuy);

            // Test getById
//            DeliveryGuy retrievedDeliveryGuy = deliveryGuyDAO.getById(newDeliveryGuy.getId());
//            System.out.println("Retrieved DeliveryGuy: " + retrievedDeliveryGuy);

            // Test getAll
            List<DeliveryGuy> allDeliveryGuys = deliveryGuyDAO.getAll();
            System.out.println("All DeliveryGuys: " + allDeliveryGuys);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
