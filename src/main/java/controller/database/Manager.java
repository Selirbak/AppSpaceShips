package controller.database;

import objects.SpaceShip;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class Manager extends ConnectionDB {

    public static List<SpaceShip> getAllShips() throws SQLException {
        consultAll();
        return shipList;
    }
    public static Map<Integer, String> typeShips(){
       return consultTypeShip();
    }
    public static int quantityRegister(){
        return consultRegister();
    }
    public static void insertData(List<SpaceShip> spaceShips) {
        for (SpaceShip spaceShip : spaceShips) {
            insert(spaceShip);
        }
    }
}
