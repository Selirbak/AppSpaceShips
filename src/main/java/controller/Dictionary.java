package controller;

import java.util.HashMap;
import java.util.Map;

public abstract class Dictionary {
    public class Message {
        public class Information {
            public static final String WELCOME = "Bienvenido a la APP de su estación espacial";
            public static final String START_MENU = "Que deseas realizar hoy: \n";
            public static final String OPCION_ONE = "1.Crear Nueva Nave Espacial";
            public static final String OPCION_TWO = "2.Mostrar naves disponibles";
            public static final String OPCION_THREE = "3.Buscar";
            public static final String GET_OPTION = "Ingrese la opción que necesitas :  ";
            public static final String OPTION_DEFAULT = "SI O NO";
            public static final String EXISTEN = "Existen : ";
            public static final String SEPARADOR = "----------------------------------------------\n";
            public static final String ELEGISTE_OPCION = "****Elegiste la Opcion:|| %s || *******\n";
            public static final String WELCOME_CREATE = "***SE INICIA LA CREACIÓN DE REGISTRO DE NAVES *******";

        }

        public class Error {
            public static final String OPTION_INCORRECT = "Ingresaste un caracter incorrecto";
            public static final String OPTION_NOT_FOUND = "El Dato ingresado no es correcto, Intenta nuevamente : ";
        }

    }

    public class Consultas {
        public static final String CONSULT_ALL_SHIPS = "select * from spaceshipdatabase.informationgeneral as ig\n  " +
                "inner join spaceshipdatabase.typeship as ts on ts.idShip = ig.typeShip\n left join spaceshipdatabase.behaviour as bh on bh.idShip = ig.id";
        public static final String CONSULT_TYPE_SHIP = "select * from spaceshipdatabase.typeship";
        public static final String CONSULT_QUANTITY_REGISTER = "select count(*) from spaceshipdatabase.informationgeneral";
    }

    public class DetailsShips {
        public static Map<String, String> value() {
            Map<String, String> map = new HashMap<>();
            map.put("id", "Identificador : ");
            map.put("name", "Nombre * : ");
            map.put("isActiva", "Estado * : ");
            map.put("useFuel", "Usa Combustible? * : ");
            map.put("fuelType", "Tipo De Combustible : ");
            map.put("origin", "Origen * : ");
            map.put("typeShip", "Tipo De Nave * : ");
            map.put("power", "Potencia : ");
            map.put("isPeople", "Carga Personas? * : ");
            map.put("isSupplies", "Carga Suministros? * : ");
            map.put("isEquipment", "Carga Equipamientos? * : ");
            return map;
        }
    }
}
