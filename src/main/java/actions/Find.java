package actions;

import controller.Collect.FindTo;
import controller.Dictionary;
import controller.ImplementMenu;
import controller.Utilities;
import controller.database.Manager;
import objects.SpaceShip;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static controller.Dictionary.Message.Information.ELEGISTE_OPCION;

public class Find extends ImplementMenu {
    List<String> possibleOption = new ArrayList<>();

    public void init() {
        try {
            Manager.getAllShips();
            List<String> menu = getMenuFilter();
            Utilities.printMenu(menu);
            int option = getSelectionOption(menu);
            Utilities.showMessaje(String.format(ELEGISTE_OPCION, menu.get(option - 1)));
            Utilities.showMessaje("****Estas son las posibles opciones a Filtrar");
            findTo(option);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void findTo(int option) {
        FindTo filter = new FindTo();

        Map<String, List<SpaceShip>> auxiliar = null;
        Map<Boolean, List<SpaceShip>> auxiliarBolean = null;
        String title = "";
        switch (option) {
            case 1 -> auxiliar = filter.toTypeShip();
            case 2 -> {
                auxiliarBolean = filter.toUsedFuel();
                title = "Usan";
            }
            case 3 -> auxiliar = filter.toFueld();
            case 4 -> auxiliar = filter.toOrigin();
            case 5 -> {
                auxiliarBolean = filter.toIsActive();
                title = "Activo";
            }
        }
        int possibleOpcion;
        if (auxiliar != null) {
            possibleOpcion = printMenuPossible(auxiliar);
            printInformation(auxiliar, possibleOpcion);
        } else if (auxiliarBolean != null) {
            possibleOpcion = printMenuPossible(auxiliarBolean, title);
            printInformation(auxiliarBolean, possibleOpcion, title);
        }


    }

    private void printInformation(Map<String, List<SpaceShip>> auxiliar, int opcionposiible) {
        for (Map.Entry<String, List<SpaceShip>> entry : auxiliar.entrySet()) {
            if (possibleOption.get(opcionposiible - 1).contains(entry.getKey())) {
                printInformation(entry.getValue());
            }

        }
    }

    private void printInformation(Map<Boolean, List<SpaceShip>> auxiliar, int opcionposiible, String title) {
        for (Map.Entry<Boolean, List<SpaceShip>> entry : auxiliar.entrySet()) {
            String value = entry.getKey() ? "Si " : "No ".concat(title);
            if (possibleOption.get(opcionposiible - 1).contains(value)) {
                printInformation(entry.getValue());
            }

        }
    }

    private int printMenuPossible(Map<String, List<SpaceShip>> auxiliar) {
        int count = 0;
        for (Map.Entry<String, List<SpaceShip>> entry : auxiliar.entrySet()) {
            count++;
            possibleOption.add(String.valueOf(count).concat(".").concat(entry.getKey()));
        }
        Utilities.printMenu(possibleOption);
        int option = getSelectionOption(possibleOption);
        Utilities.showMessaje(String.format(ELEGISTE_OPCION, possibleOption.get(option - 1)));
        return option;
    }

    private int printMenuPossible(Map<Boolean, List<SpaceShip>> auxiliar, String title) {
        int count = 0;
        for (Map.Entry<Boolean, List<SpaceShip>> entry : auxiliar.entrySet()) {
            count++;
            String value;
            if (entry.getKey()) {
                value = " Si ".concat(title);
            } else {
                value = " No ".concat(title);
                ;
            }
            String concat = String.valueOf(count).concat(".").concat(value);
            possibleOption.add(concat);
            Utilities.showMessaje(concat);
        }
        int option;
        do {
            option = getOption(possibleOption);
        } while (option < 0);
        Utilities.showMessaje(ELEGISTE_OPCION + possibleOption.get(option - 1));
        return option;
    }

    private void printInformation(List<SpaceShip> entry) {
        for (SpaceShip spaceShip : entry) {
            Utilities.showMessaje(Dictionary.Message.Information.SEPARADOR);
            for (Field field : spaceShip.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                try {
                    String name = field.getName();
                    if (name.equals("loadType")) {
                        for (Field fieldAux : spaceShip.getLoadType().getClass().getDeclaredFields()) {
                            fieldAux.setAccessible(true);
                            Utilities.showMessaje(Utilities.getTitle(fieldAux.getName(), Dictionary.DetailsShips.value()) + (fieldAux.get(spaceShip.getLoadType()).equals(true) ? "SI" : "NO"));

                        }

                    } else {
                        Object valor = field.get(spaceShip);
                        valor = valor == null ? "" : valor;
                        Utilities.showMessaje(Utilities.getTitle(name, Dictionary.DetailsShips.value()) + valor);
                    }

                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
            Utilities.showMessaje(Dictionary.Message.Information.SEPARADOR);
        }
    }

}
