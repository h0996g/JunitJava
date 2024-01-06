package DAO;

import com.company.DeliveryGuy;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeliveryGuyDAO {
    private Connection connection;

    public DeliveryGuyDAO(Connection connection) {
        this.connection = connection;
    }

    // Insert a new DeliveryGuy
    public void insert(DeliveryGuy deliveryGuy) throws SQLException {
        String sql = "INSERT INTO DELIVERY_GUY (ID, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD, PHONE_NUMBER, STATUS) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, deliveryGuy.getId());
            preparedStatement.setString(2, deliveryGuy.getFirstName());
            preparedStatement.setString(3, deliveryGuy.getLastName());
            preparedStatement.setString(4, deliveryGuy.getEmail());
            preparedStatement.setString(5, deliveryGuy.getPassword());
            preparedStatement.setString(6, deliveryGuy.getPhoneNumber());
            preparedStatement.setString(7, deliveryGuy.getStatus().name()); // Assuming STATUS is a String column
            preparedStatement.executeUpdate();
        }
    }

    // Retrieve a DeliveryGuy by ID
    public DeliveryGuy getById(int id) throws SQLException {
        String sql = "SELECT * FROM DELIVERY_GUY WHERE ID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return extractDeliveryGuyFromResultSet(resultSet);
                }
            }
        }
        return null;
    }

    // Retrieve all DeliveryGuys
    public List<DeliveryGuy> getAll() throws SQLException {
        List<DeliveryGuy> deliveryGuys = new ArrayList<>();
        String sql = "SELECT * FROM DELIVERYGUY";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                DeliveryGuy deliveryGuy = extractDeliveryGuyFromResultSet(resultSet);
                deliveryGuys.add(deliveryGuy);
            }
        }
        return deliveryGuys;
    }

    private DeliveryGuy extractDeliveryGuyFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("DELIVERY_GUY_ID");
        String firstName = resultSet.getString("FIRST_NAME");
        String lastName = resultSet.getString("LAST_NAME");
        String email = resultSet.getString("EMAIL");
        String password = resultSet.getString("PASSWORD");
        String phoneNumber = resultSet.getString("PHONE_NUMBER");
        String statusString = resultSet.getString("STATUS");
        DeliveryGuy.Status status = DeliveryGuy.Status.valueOf(statusString); // Assuming STATUS is a String column
        return new DeliveryGuy(id, firstName, lastName, email, password, phoneNumber, status);
    }
}
