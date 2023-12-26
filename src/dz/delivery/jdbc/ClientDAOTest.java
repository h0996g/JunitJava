package dz.delivery.jdbc;

import com.company.Agent;
import com.company.OracleConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class ClientDAOTest {

    public static void main(String[] args) {
        // Replace these values with your actual database connection details
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE";
        String username = "delivery";
        String password = "12";

        // JDBC variables for managing Oracle connections
        try (Connection connection = OracleConnection.getConnection(jdbcUrl, username, password)) {
            // Create an instance of ClientDAO

            AgentDAO clientDAO = new AgentDAO(connection);

            // Replace '1' with the actual client ID you want to retrieve
            int clientId = 2;

            // Call the getById function and print the results
            Agent client = AgentDAO.getById(clientId);

            if (client != null) {
                System.out.println("Client ID: " + client.getAGENT_ID());
                System.out.println("Client Name: " + client.getFIRST_NAME() + " " + client.getLAST_NAME());
                System.out.println("Client Email: " + client.getEMAIL());
                // ... other client properties
            } else {
                System.out.println("Client not found with ID: " + clientId);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
