package actions;

import controller.Collect.FindTo;
import controller.ImplementMenu;
import controller.Utilities;
import controller.database.Manager;
import objects.SpaceShip;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Find extends ImplementMenu {
    public void init() {
        try {

            Manager.getAllShips();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void findTo() {
        FindTo filter = new FindTo();
        try {
            Manager.getAllShips();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < getMenuFilter().size(); i++) {
            Utilities.showMessaje(getMenuFilter().get(i));
        }
        int option;
        do {
            option = getOption(getMenuFilter());
        } while (option < 0);
        Utilities.showMessaje("La opcion que elegiste es :" + getMenuFilter().get(option - 1));
        List<String> possibleOption = new ArrayList<>();
        int count =0;
        switch (option) {
            case 1:
                Map<String, List<SpaceShip>> auxiliar = filter.toTypeShip();

                for (Map.Entry<String, List<SpaceShip>> entry : auxiliar.entrySet()) {
                    count++;
                    possibleOption.add(String.valueOf(count).concat(".").concat(entry.getKey()));
                    Utilities.showMessaje(String.valueOf(count).concat(".").concat(entry.getKey()));
                }
                int option2 =   getOption(possibleOption);
                Utilities.showMessaje("Elegiste :" + possibleOption.get(option2 - 1));
                for (Map.Entry<String, List<SpaceShip>> entry : auxiliar.entrySet()) {
                    if (possibleOption.get(option2 - 1) .contains(entry.getKey())){
                        printInformation(entry);
                    }

                }


             //
                break;
            case 2:
                break;
            case 3:

                break;
        }

    }

    private void printInformation(Map.Entry<String, List<SpaceShip>> entry) {
        for (int i = 0; i < entry.getValue().size(); i++) {
            for (Field field : entry.getValue().get(i).getClass().getDeclaredFields()) {
                field.setAccessible(true);
                try {
                    String name = field.getName();
                    if (name.equals("loadType")) {
                        for (Field fieldAux : entry.getValue().get(i).getLoadType().getClass().getDeclaredFields()) {
                            fieldAux.setAccessible(true);
                            Utilities.showMessaje(fieldAux.getName() + " : " + (fieldAux.get(entry.getValue().get(i).getLoadType()).equals(true) ? "SI" : "NO"));

                        }

                    } else {
                        Utilities.showMessaje(name + " : " + field.get(entry.getValue().get(i)));
                    }

                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        Utilities.showMessaje(entry.getKey() + " : " + entry.getValue().size());

    }

}
