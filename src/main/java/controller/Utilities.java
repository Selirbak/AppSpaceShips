package controller;

import java.util.List;

public class Utilities {

    public static void showMessaje(String mensaje) {
        System.out.println(mensaje);
    }

    public static void showMessajeFail(String mensaje) {
        System.err.println(mensaje);
    }

    public static void printMenu(List<String> menu) {
        Utilities.showMessaje(Dictionary.Message.Information.SEPARADOR);
        for (String opcion : menu) {
            String message = "|     ".concat(opcion);
            showMessaje(message);
        }
        Utilities.showMessaje(Dictionary.Message.Information.SEPARADOR);
    }


}
