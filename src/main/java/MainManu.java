import controller.Dictionary;
import controller.Utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainManu {


    public void start() {
        Utilities.showMessaje(Dictionary.Message.Information.WELCOME);
        Utilities.showMessaje(Dictionary.Message.Information.START_MENU);
        for (int i = 0; i < getMenu().size(); i++) {
            Utilities.showMessaje(getMenu().get(i));
        }
        int option;
        do {
            option = getOption();
        } while (option < 0);
        Utilities.showMessaje("La opcion que elegiste es :" + option);

    }
    private int getOption() {
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
            esPossibleContinue = option > getMenu().size() || option <= 0;
            if (esPossibleContinue) {
                Utilities.showMessajeFail(Dictionary.Message.Error.OPTION_NOT_FOUND);
            }
        } while (esPossibleContinue);
        return option;
    }
    private List<String> getMenu() {
        List<String> menu = new ArrayList<>();
        menu.add(Dictionary.Message.Information.OPCION_ONE);
        menu.add(Dictionary.Message.Information.OPCION_TWO);
        menu.add(Dictionary.Message.Information.OPCION_THREE);
        return menu;
    }


}
