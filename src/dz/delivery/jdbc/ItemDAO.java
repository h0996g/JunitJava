package dz.delivery.jdbc;

import com.company.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {
    private Connection connection;

    public ItemDAO(Connection connection) {
        this.connection = connection;
    }

    // Insert a new Item
    public void insert(Item item) throws SQLException {
        String sql = "INSERT INTO ITEM (ID, NAME, DESCRIPTION, PRICE) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, item.getId());
            preparedStatement.setString(2, item.getName());
            preparedStatement.setString(3, item.getDescription());
            preparedStatement.setDouble(4, item.getPrice());
            preparedStatement.executeUpdate();
        }
    }

    // Retrieve an Item by ID
    public Item getById(int id) throws SQLException {
        String sql = "SELECT * FROM ITEM WHERE ID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return extractItemFromResultSet(resultSet);
                }
            }
        }
        return null;
    }

    // Retrieve all Items
    public List<Item> getAll() throws SQLException {
        List<Item> items = new ArrayList<>();
        String sql = "SELECT * FROM ITEM";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Item item = extractItemFromResultSet(resultSet);
                items.add(item);
            }
        }
        return items;
    }

    private Item extractItemFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("ITEM_ID");
        String name = resultSet.getString("NAME");
        String description = resultSet.getString("DESCRIPTION");
        double price = resultSet.getDouble("PRICE");
        return new Item(id, name, description, price);
    }
}
