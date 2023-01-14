import actions.Create;
import actions.Find;
import actions.Reset;
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
            case 1 -> {
                Create create = new Create();
                create.init();
            }
            case 2 -> {
                Show show = new Show();
                show.init();
            }
            case 3 -> {
                Find find = new Find();
                find.init();
            }
            case 4 -> {
                Reset reset = new Reset();
                reset.init();
            }
        }
        if(option!=5){
            start();
        }




    }


}
