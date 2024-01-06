package DAO;

import com.company.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDAO {

    private final Connection connection;

    public ClientDAO(Connection connection) {
        this.connection = connection;
    }

    public Client getById(int clientId) throws SQLException {
        String query = "SELECT * FROM client WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, clientId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return extractClientFromResultSet(resultSet);
                }
            }
        }
        return null; // Client not found
    }

    private Client extractClientFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String firstName = resultSet.getString("firstname");
        String lastName = resultSet.getString("lastname");
        String email = resultSet.getString("email");
        String password = resultSet.getString("password");
        String phoneNumber = resultSet.getString("phone_number");
        String profilePhotoPath = resultSet.getString("profile_photo_path");

        return new Client(id, firstName, lastName, email, password, phoneNumber, profilePhotoPath);
    }
}
