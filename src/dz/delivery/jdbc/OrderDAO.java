package dz.delivery.jdbc;

import com.company.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class OrderDAO {
    private final Connection connection;

    public OrderDAO(Connection connection) {
        this.connection = connection;
    }

    // Other methods for CRUD operations...

    // Insert or update an order
    public void saveOrder(Order order) throws SQLException {
        // Existing code for saveOrder method...

    }

    // Retrieve all orders
    public Set<Order> getAllOrders() throws SQLException {
        String sql = "SELECT * FROM orders";
        Set<Order> orders = new HashSet<>();

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt("order_id"));
                order.setReview(resultSet.getString("review"));
                order.setEvaluation(resultSet.getInt("evaluation"));
                order.setCreatedAt(resultSet.getTimestamp("created_at"));
                order.setConfirmedAt(resultSet.getTimestamp("confirmed_at"));
                order.setDeliveredAt(resultSet.getTimestamp("delivered_at"));
                order.setStatus(resultSet.getObject("status", Order.Status.class));

                orders.add(order);
            }
        }

        return orders;
    }

    // Other methods for retrieving specific orders, etc.
}
