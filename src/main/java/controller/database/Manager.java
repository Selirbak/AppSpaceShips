package controller.database;

import controller.Dictionary;
import objects.SpaceShip;

import java.sql.SQLException;
import java.util.List;

public class Manager extends ConnectionDB {

    public static List<SpaceShip> getAllShips() throws SQLException {
        consult(Dictionary.Consultas.CONSULT_ALL_SHIPS);
        return shipList;
    }
}
