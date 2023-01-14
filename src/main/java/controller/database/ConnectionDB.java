package controller.database;

import objects.LoadType;
import objects.SpaceShip;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConnectionDB {
    protected static List<SpaceShip> shipList;

    static void consultAll() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "root");
             PreparedStatement statement = connection.prepareStatement(controller.Dictionary.Consultas.CONSULT_ALL_SHIPS);
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

    static Map<Integer, String> consultTypeShip() {
        Map<Integer, String> types = new HashMap<>();
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "root");
             PreparedStatement statement = connection.prepareStatement(controller.Dictionary.Consultas.CONSULT_TYPE_SHIP);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                types.put(resultSet.getInt(1), resultSet.getString(2));
            }
        } catch (SQLException e) {
            throw new IllegalStateException("No se pudo conectar ala base de datosa", e);
        }
        return types;
    }

    static int consultRegister() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "root");
             PreparedStatement statement = connection.prepareStatement(controller.Dictionary.Consultas.CONSULT_QUANTITY_REGISTER);
             ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new IllegalStateException("No se pudo conectar ala base de datosa", e);
        }
        return 0;
    }

    static void insert(SpaceShip query) {
        String sql = "INSERT INTO spaceshipdatabase.informationgeneral VALUE (?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "root");
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, 0);
            statement.setString(2, query.getName());
            statement.setBoolean(3, query.getActiva());
            statement.setBoolean(4, query.isUseFuel());
            statement.setString(5, query.getFuelType());
            statement.setString(6, query.getOrigin());
            statement.setInt(7, Integer.parseInt(query.getTypeShip().split("\\.")[0])); //
            statement.setString(8, query.getPower());
            statement.setBoolean(9, query.getLoadType().isPeople());
            statement.setBoolean(10, query.getLoadType().isSupplies());
            statement.setBoolean(11, query.getLoadType().isEquipment());
            statement.execute();
        } catch (SQLException e) {
            throw new IllegalStateException("No se pudo conectar ala base de datosa", e);
        }
    }


    static void resetTable() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "root");
             PreparedStatement statement = connection.prepareStatement(controller.Dictionary.Consultas.RESET_ALL_TABLE)) {
            statement.execute();
        } catch (SQLException e) {
            throw new IllegalStateException("No se pudo conectar ala base de datosa", e);
        }

    }
}
