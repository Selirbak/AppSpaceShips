package actions;

import controller.Collect.FindTo;
import controller.Utilities;
import controller.database.Manager;
import objects.SpaceShip;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

public class Show {


    public void init() {
        FindTo filter = new FindTo();
        try {
            Utilities.showMessaje("Existen " + Manager.getAllShips().size() + " Naves Totales");
            Utilities.showMessaje("De las cuales hay:");
            printInventory("TIPO DE NAVES", filter.toTypeShip());
            printInventory("USAN COMBUSTIBLE", filter.toUsedFuel(), false);
            printInventory("COMBUSTIBLE", filter.toFueld());
            printInventory("ORIGEN", filter.toOrigin());
            printInventory("ESTADO DE NAVES", filter.toIsActive(), true);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private void printInventory(String title, Map<String, List<SpaceShip>> type) {
        Utilities.showMessaje("----------------------------------------------");
        Utilities.showMessaje(title);
        for (Map.Entry<String, List<SpaceShip>> entry : type.entrySet()) {
            Utilities.showMessaje(entry.getKey() + " : " + entry.getValue().size());
        }
    }

    private void printInventory(String title, Map<Boolean, List<SpaceShip>> type, boolean isActive) {
        Utilities.showMessaje("----------------------------------------------");
        Utilities.showMessaje(title);
        for (Map.Entry<Boolean, List<SpaceShip>> entry : type.entrySet()) {
            if (isActive) {
                if (!entry.getKey()) {
                    Utilities.showMessaje("Inactivas : " + entry.getValue().size());
                } else {
                    Utilities.showMessaje("Activas : " + entry.getValue().size());
                }
            } else {
                if (!entry.getKey()) {
                    Utilities.showMessaje(entry.getValue().size() + " no usan");
                } else {
                    Utilities.showMessaje(entry.getValue().size() + " si usan");
                }

            }

        }
    }
}
