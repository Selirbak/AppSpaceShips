package controller.database;

import objects.LoadType;
import objects.SpaceShip;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConnectionDB {
    protected static List<SpaceShip> shipList;

    static void consult(String query) {

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "root");
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            shipList = new ArrayList<>();
            while (resultSet.next()) {
                shipList.add(new SpaceShip(resultSet.getString(1),
                                resultSet.getString(2),
                                resultSet.getBoolean(3),
                                resultSet.getBoolean(4),
                                resultSet.getString(5),
                                resultSet.getString(6),
                                resultSet.getString(13),
                                resultSet.getString(8),
                                new LoadType(resultSet.getBoolean(9),
                                        resultSet.getBoolean(10),
                                        resultSet.getBoolean(11))
                        )
                );
            }
        } catch (SQLException e) {
            throw new IllegalStateException("No se pudo conectar ala base de datosa", e);
        }
    }

    private ResultSet insert(String query) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "root");
             PreparedStatement statement = connection.prepareStatement(query)) {
            return statement.executeQuery();
        } catch (SQLException e) {
            throw new IllegalStateException("No se pudo conectar ala base de datosa", e);
        }
    }
}
