package dz.delivery.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.company.Agent;

public class AgentDAO {
    private static Connection connection;

    public AgentDAO(Connection connection) {
        this.connection = connection;
    }

    public void insert(Agent agent) throws SQLException {
        String query = "INSERT INTO agent (firstname, lastname, email, password, phonenumber, ip_address) " +
                "VALUES ('" + agent.getFIRST_NAME() + "', '" + agent.getLAST_NAME() + "', '" +
                agent.getEMAIL() + "', '" + agent.getPASSWORD() + "', '" +
                agent.getPHONE_NUMBER() + "', '" + agent.getIPADDRESS() + "')";
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        }
    }

    public static Agent getById(int id) throws SQLException {
        String query = "SELECT * FROM agent WHERE agent_id = " + id;
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            if (resultSet.next()) {
                return extractAgentFromResultSet(resultSet);
            }
        }
        return null;
    }

    public List<Agent> getAll() throws SQLException {
        List<Agent> agents = new ArrayList<>();
        String query = "SELECT * FROM agent";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                agents.add(extractAgentFromResultSet(resultSet));
            }
        }
        return agents;
    }

    private static Agent extractAgentFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("AGENT_ID");
        String firstName = resultSet.getString("FIRST_NAME");
        String lastName = resultSet.getString("LAST_NAME");
        String email = resultSet.getString("EMAIL");
        String password = resultSet.getString("PASSWORD");
        String phoneNumber = resultSet.getString("PHONE_NUMBER");
        String ipAddress = resultSet.getString("IPADDRESS");

        return new Agent(id, firstName, lastName, email, password, phoneNumber, ipAddress);
    }
}
