package dz.delivery.jdbc;

import com.company.Agent;
import com.company.OracleConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class AgentDAOTest {

    public static void main(String[] args) {
        // Replace these values with your actual database connection details
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE";
        String username = "Delivery";
        String password = "12";

        // JDBC variables for managing Oracle connections
        Connection connection = null;

        try {
            // Get a connection using OracleConnection class
            connection = OracleConnection.getConnection(jdbcUrl, username, password);

            // Create an instance of AgentDAO
            AgentDAO agentDAO = new AgentDAO(connection);

            // Call the getAll function and print the results
            List<Agent> agents = agentDAO.getAll();

            for (Agent agent : agents) {
                System.out.println(agent.getAGENT_ID() + ": " + agent.getFIRST_NAME() + " " + agent.getLAST_NAME());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the connection using OracleConnection class
            OracleConnection.closeConnection(connection);
        }
    }
}
