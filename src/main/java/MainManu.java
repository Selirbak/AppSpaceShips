import actions.Create;
import actions.Find;
import actions.Show;
import controller.Dictionary;
import controller.ImplementMenu;
import controller.Utilities;

import java.util.List;

import static controller.Dictionary.Message.Information.ELEGISTE_OPCION;

public class MainManu extends ImplementMenu {


    public void start() {
        Utilities.showMessaje(Dictionary.Message.Information.WELCOME);
        Utilities.showMessaje(Dictionary.Message.Information.START_MENU);
        List<String> mainMenu = getMenu();
        Utilities.printMenu(mainMenu);
        int option = getSelectionOption(mainMenu);
        Utilities.showMessaje(String.format(ELEGISTE_OPCION, mainMenu.get(option - 1)));
        switch (option) {
            case 1:
                Create create = new Create();
                create.init();
                break;
            case 2:
                Show show = new Show();
                show.init();
                break;
            case 3:
                Find find = new Find();
                find.init();
                break;
        }


    }


}
