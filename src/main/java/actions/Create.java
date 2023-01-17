package actions;

import controller.Collect.FindTo;
import controller.Dictionary;
import controller.ImplementMenu;
import controller.Utilities;
import controller.database.Manager;
import objects.LoadType;
import objects.SpaceShip;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static controller.Dictionary.Message.Information.ELEGISTE_OPCION;


public class Create extends ImplementMenu {
    List<SpaceShip> ships = new ArrayList<>();

    public void init() {
        Utilities.showMessaje(Dictionary.Message.Information.WELCOME_CREATE);
        createNewShip();
    }

    private List<String> typesShips() {
        List<String> strings = new ArrayList<>();
        Map<Integer, String> typesShips = Manager.typeShips();
        for (Map.Entry<Integer, String> entry : typesShips.entrySet()) {
            strings.add(String.valueOf(entry.getKey()).concat("." + entry.getValue()));
        }
        return strings;
    }

    private void createNewShip() {
        List<SpaceShip> listShip = new ArrayList<>();
        Utilities.showMessaje("Los datos marcados con un * son datos obligatorios: ");
        int quantity = Manager.quantityRegister();
        FindTo find = new FindTo();
        Map<String, List<SpaceShip>> listMap;
        boolean continuee = false;
        do {
            listShip.add(requestInformation(typesShips()));
            Utilities.showMessaje("Deseas registrar una nueva Nave");
            continuee = isBoolean("SI", "NO");
            listMap = find.toTypeShip(listShip);

            if (quantity < 4) {
                if (listMap.size() < 4) {
                    if (!continuee) {
                        Utilities.showMessaje("RECUERDA QUE PARA INICIAR DEBES INGRESAR AL MENOS 4 NAVES DE TIPOS DIFERENTES");
                        Utilities.showMessaje("POR EL MOMENTO SOLO HAS INGRESADO");
                        for (Map.Entry<String, List<SpaceShip>> entry : listMap.entrySet()) {
                            Utilities.showMessaje(entry.getKey() + ": " + entry.getValue().size());
                        }
                    }
                    continuee = false;
                }
            }
        } while (continuee ^ (quantity < 4 ^ listMap.size() >= 4));

        Manager.insertData(listShip);
    }


    private SpaceShip requestInformation(List<String> typesShips) {
        Scanner scanner = new Scanner(System.in);
        Utilities.showMessaje(Dictionary.Message.Information.SEPARADOR);
        SpaceShip spaceShip = new SpaceShip();
        for (Field field : spaceShip.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                String type = field.getType().getName();
                String name = field.getName();
                String value;
                boolean valueB;
                String namePresent = null;
                if (type.contains("LoadType")) {
                    spaceShip.setLoadType(new LoadType(false, false, false));
                    for (Field field2 : spaceShip.getLoadType().getClass().getDeclaredFields()) {
                        namePresent = Utilities.getTitle(field2.getName(), Dictionary.DetailsShips.value());
                        Utilities.showMessajeInsert(namePresent);
                        field2.setBoolean(spaceShip.getLoadType(), isBoolean("SI", "NO"));
                    }
                } else if (!name.equals("id") && !name.equals("loadType")) {
                    if (!name.equals("fuelType") || spaceShip.isUseFuel()) {
                        namePresent = Utilities.getTitle(name, Dictionary.DetailsShips.value());
                        Utilities.showMessajeInsert(namePresent);
                    }


                    if (type.contains("boolean")) {
                        if (name.contains("use")) {
                            valueB = isBoolean("Si Usa", "No Usa");
                        } else {
                            valueB = isBoolean("Activo", "Inactivo");
                        }

                        field.setBoolean(spaceShip, valueB);
                    } else if (type.contains("String")) {
                        if (!name.equals("fuelType") || spaceShip.isUseFuel()) {

                            if (name.equals("typeShip")) {
                                Utilities.printMenu(typesShips);
                                int option = getSelectionOption(typesShips);
                                Utilities.showMessaje(String.format(ELEGISTE_OPCION, typesShips.get(option - 1)));
                                value = typesShips.get(option - 1);
                            } else {
                                value = scanner.nextLine();
                                while (namePresent.contains("*") && value.isEmpty()) {
                                    Utilities.showMessajeFail("es un campo obligatorio ingresalo por favor:");
                                    Utilities.showMessajeInsert(Dictionary.Message.Information.SEPARADOR);
                                    Utilities.showMessajeInsert(namePresent);
                                    value = scanner.nextLine();
                                }
                            }
                            field.set(spaceShip, value);
                        }
                    }
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        Utilities.showMessaje(Dictionary.Message.Information.SEPARADOR);
        return spaceShip;
    }

    public boolean isBoolean(String title1, String title2) {
        List<String> possibleOption = new ArrayList<>();
        possibleOption.add("1. ".concat(title1));
        possibleOption.add("2. ".concat(title2));
        Utilities.showMessajeInsert("\n");
        Utilities.printMenu(possibleOption);
        int opcion = getSelectionOption(possibleOption);
        return opcion == 1;

    }

}
