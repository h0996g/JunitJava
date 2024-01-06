package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.company.Address;

public class AddressDAO {
    // You need to have a database connection, adjust the Connection type based on your database
    private Connection connection;

    public AddressDAO(Connection connection) {
        this.connection = connection;
    }

    // Insert a new address into the database
    public void insert(Address address) throws SQLException {
        String query = "INSERT INTO address (street, city, postal_code, country, latitude, longitude) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, address.getStreet());
            statement.setString(2, address.getCity());
            statement.setString(3, address.getPostalCode());
            statement.setString(4, address.getCountry());
            statement.setDouble(5, address.getLatitude());
            statement.setDouble(6, address.getLongitude());
            statement.executeUpdate();
        }
    }

    // Retrieve an address by ID from the database
    public Address getById(int id) throws SQLException {
        String query = "SELECT * FROM address WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return extractAddressFromResultSet(resultSet);
                }
            }
        }
        return null;
    }

    // Retrieve all addresses from the database
    public List<Address> getAll() throws SQLException {
        List<Address> addresses = new ArrayList<>();
        String query = "SELECT * FROM address";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                addresses.add(extractAddressFromResultSet(resultSet));
            }
        }
        return addresses;
    }

    private Address extractAddressFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String street = resultSet.getString("street");
        String city = resultSet.getString("city");
        String postalCode = resultSet.getString("postal_code");
        String country = resultSet.getString("country");
        double latitude = resultSet.getDouble("latitude");
        double longitude = resultSet.getDouble("longitude");

        return new Address(id, street, city, postalCode, country, latitude, longitude);
    }
}
