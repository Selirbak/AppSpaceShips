package controller.database;

import java.sql.*;

public class ConnectionDB {
    public ResultSet consult(String query) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "root");
             PreparedStatement statement = connection.prepareStatement(query)) {
            return statement.executeQuery();
        } catch (SQLException e) {
            throw new IllegalStateException("No se pudo conectar ala base de datosa", e);
        }
    }
    public ResultSet insert(String query) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "root");
             PreparedStatement statement = connection.prepareStatement(query)) {
            return statement.executeQuery();
        } catch (SQLException e) {
            throw new IllegalStateException("No se pudo conectar ala base de datosa", e);
        }
    }
}
