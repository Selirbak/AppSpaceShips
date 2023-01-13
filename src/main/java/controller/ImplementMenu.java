package controller;

import controller.Dictionary;
import controller.Utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ImplementMenu {
    public int getOption(List<String> menu) {
        Scanner scanner;
        int option = -1;
        boolean esPossibleContinue;
        Utilities.showMessaje(Dictionary.Message.Information.GET_OPTION);
        do {
            try {
                scanner = new Scanner(System.in);
                option = scanner.nextInt();
            } catch (Exception e) {
                Utilities.showMessajeFail(Dictionary.Message.Error.OPTION_INCORRECT);
            }
            esPossibleContinue = option > menu.size() || option <= 0;
            if (esPossibleContinue) {
                Utilities.showMessajeFail(Dictionary.Message.Error.OPTION_NOT_FOUND);
            }
        } while (esPossibleContinue);
        return option;
    }

    public List<String> getMenu() {
        List<String> menu = new ArrayList<>();
        menu.add(Dictionary.Message.Information.OPCION_ONE);
        menu.add(Dictionary.Message.Information.OPCION_TWO);
        menu.add(Dictionary.Message.Information.OPCION_THREE);
        return menu;
    }

    public List<String> getMenuFilter() {
        List<String> menu = new ArrayList<>();
        menu.add("1. TIPO DE NAVES");
        menu.add("2. USAN COMBUSTIBLE");
        menu.add("3. COMBUSTIBLE");
        menu.add("4. ORIGEN");
        menu.add("5. ESTADO DE NAVES");
        return menu;
    }
}
