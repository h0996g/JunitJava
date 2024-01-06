package DAO;

import com.company.Client;
import com.company.OracleConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class ClientDAOTest {

    public static void main(String[] args) {
        // Replace these values with your actual database connection details
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE";
        String username = "hiber";
        String password = "12";

        // JDBC variables for managing Oracle connections
        try (Connection connection = OracleConnection.getConnection(jdbcUrl, username, password)) {
            // Create an instance of ClientDAO
            ClientDAO clientDAO = new ClientDAO(connection);

            // Replace '1' with the actual client ID you want to retrieve
            int clientId = 1;

            // Call the getById function and print the results
            Client client = clientDAO.getById(clientId);

            if (client != null) {
                System.out.println("Client ID: " + client.getId());
                System.out.println("Client Name: " + client.getFirstName() + " " + client.getLastName());
                System.out.println("Client Email: " + client.getEmail());
                // ... other client properties
            } else {
                System.out.println("Client not found with ID: " + clientId);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
