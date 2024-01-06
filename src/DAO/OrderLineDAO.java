package DAO;

import com.company.OrderLine;
import com.company.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderLineDAO {

    private Connection connection;

    public OrderLineDAO(Connection connection) {
        this.connection = connection;
    }

    // Save or update an OrderLine
    public void saveOrUpdateOrderLine(OrderLine orderLine) {
        try {
            if (orderLine.getrOrder() == null || orderLine.getItem() == null) {
                // Handle error: Order and Item should be set
                return;
            }

            if (getOrderLineById(orderLine.getrOrder().getOrderId()) == null) {
                // Insert a new order line
                insertOrderLine(orderLine);
            } else {
                // Update the existing order line
                updateOrderLine(orderLine);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle SQLException
        }
    }

    // Insert a new OrderLine
    private void insertOrderLine(OrderLine orderLine) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO order_line (quantity, photoFilePath, item_id, order_id) VALUES (?, ?, ?, ?)")) {
            preparedStatement.setInt(1, orderLine.getQuantity());
            preparedStatement.setString(2, orderLine.getPhotoFilePath());
            preparedStatement.setInt(3, orderLine.getItem().getItemId());
            preparedStatement.setInt(4, orderLine.getrOrder().getOrderId());

            // Execute the SQL statement
            preparedStatement.executeUpdate();
        }
    }

    // Update an existing OrderLine
    private void updateOrderLine(OrderLine orderLine) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement("UPDATE order_line SET quantity=?, photoFilePath=?, item_id=? WHERE order_id=?")) {
            preparedStatement.setInt(1, orderLine.getQuantity());
            preparedStatement.setString(2, orderLine.getPhotoFilePath());
            preparedStatement.setInt(3, orderLine.getItem().getItemId());
            preparedStatement.setInt(4, orderLine.getrOrder().getOrderId());

            // Execute the SQL statement
            preparedStatement.executeUpdate();
        }
    }

    // Retrieve an OrderLine by Order ID
    public OrderLine getOrderLineById(int orderId) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM order_line WHERE order_id=?")) {
            preparedStatement.setInt(1, orderId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    OrderLine orderLine = new OrderLine(resultSet.getInt("quantity"), resultSet.getString("photoFilePath"));
                    // Set other properties
                    return orderLine;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle SQLException
        }
        return null;
    }

    // Other methods for deleting and listing order lines can be added here

    // Close the connection
    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle SQLException
        }
    }
}
