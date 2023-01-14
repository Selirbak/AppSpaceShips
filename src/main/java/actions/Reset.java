package actions;

import controller.Utilities;
import controller.database.Manager;

public class Reset {
    public void init(){
        Manager.reset_Table();
        Utilities.showMessaje("Se elimino todsos los registros de la tabla correctamente.");
    }
}
