package controller;

import java.util.List;
import java.util.Map;

public class Utilities {

    public static void showMessaje(String mensaje) {
        System.out.println(mensaje);
    }

    public static void showMessajeInsert(String mensaje) {
        System.out.print(mensaje);
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

    public static String getTitle(String value, Map<String, String> type) {
        for (Map.Entry<String, String> entry : type.entrySet()) {
            if (entry.getKey().equals(value)) {
                return entry.getValue();
            }
        }
        return "NO EXISTE VALOR";
    }

}
