import actions.Create;
import actions.Find;
import actions.Show;
import controller.Dictionary;
import controller.ImplementMenu;
import controller.Utilities;

public class MainManu extends ImplementMenu {


    public void start() {
        Utilities.showMessaje(Dictionary.Message.Information.WELCOME);
        Utilities.showMessaje(Dictionary.Message.Information.START_MENU);
        for (int i = 0; i < getMenu().size(); i++) {
            Utilities.showMessaje(getMenu().get(i));
        }
        int option;
        do {
            option = getOption(getMenu());
        } while (option < 0);
        Utilities.showMessaje("La opcion que elegiste es :" + getMenu().get(option - 1));
        switch (option) {
            case 1:
                Create create = new Create();
                break;
            case 2:
                Show show = new Show();
                show.init();
                break;
            case 3:
                Find find = new Find();
                find.findTo();
                break;
        }


    }


}
