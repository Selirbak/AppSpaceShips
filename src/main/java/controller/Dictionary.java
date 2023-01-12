package controller;

public abstract class Dictionary {
    public class Message {
        public class Information {
            public static final String WELCOME = "Bienvenido a la APP de su estación espacial";
            public static final String START_MENU = "Que deseas realizar hoy: \n";
            public static final String OPCION_ONE = "1.Crear Nueva Nave Espacial";
            public static final String OPCION_TWO = "2.Mostrar naves disponibles";
            public static final String OPCION_THREE = "3.Buscar";

            public static final String GET_OPTION = "Ingrese la opción que necesitas";
            public static final String OPTION_DEFAULT = "SI O NO";
        }

        public class Error {
            public static final String OPTION_INCORRECT = "Ingresaste un caracter incorrecto";
            public static final String OPTION_NOT_FOUND = "Intenta nuevamente";
        }

    }
}
