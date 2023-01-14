# Proyecto : AppSpaceShips

   Prueba tecnica para Sofka Tecnologies.
   

## Caracteristicas
   Programa que permite crear, buscar y filtrar naves espaciales con diferentes caracteristicas y comportamientos.
   
   este programa cuenta con conexion a base de datos mySql y su interacción se realiza por consola, al iniciar encontras un menú  de opciones
 <img width="416" alt="image" src="https://user-images.githubusercontent.com/110065106/212446388-aa163bb7-d7c7-4d51-8319-b6b84fb99680.png">

 
 1. Crear Nueva Nave Espacial : Te permite crear nuevas naves, guardando información relavante sobres sus caracteristicas como lo son:
      * Identificador
      *  Nombre
      *  Estado
      *  Usa Combustible?
      *  Tipo De Combustible
      *  Origen
      *  Potencia
      *  Carga Personas?
      * Carga Suministros?
      *  Carga Equipamientos?
      
      Esta información se guarda en base de datos para que se encuentre disponible en cualquier momento.
      
      <TABLA>
      
  2. Mostrar naves disponibles: Te permite saber la cantidad de naves que se han agregado discriminado por cada una de sus caracteristicas

<Foto>

  3. Buscar: Te permite filtrar naves que cuenten con ciertas caracteristicas, los tipos de filtros usuados son:
  <img width="300" alt="image" src="https://user-images.githubusercontent.com/110065106/212446751-c8090feb-3383-4583-b26d-5a32058bae62.png">
  
  cada subTipo de estos filtros se manejan segun la disponibilidad de naves que existan.
  ejemplo: Si se selecciona "1. TIPO DE NAVES" y solo existe el tipo "Lanzadera y Satelite" el filtro solo se activa para mostrar naves de Lanzadera o Satelite.Si se crea una nave de otro tipo ejemplo "Tripulada" entonces si mostrara "Lanzadera,Satelite y Tripulada" como posibles filtros.
  
  
  4.Reiniciar: Esta opción te permite eliminar todas las naves antes registras.
  
  5.Salir : Te permite salir del aplicativo.
  
  
  ##  ***Antes de iniciar *****
  1. Descargar y configurar Workbench  https://dev.mysql.com/downloads/file/?id=514051 
  2. Se debe configurar con la siguiente información:
     * host : localhost
     *  port = 3306
     * user = root
     * pwd = root
 3. Clonar este repositorio y ubicarse en la rama master
 4. Importar desde Workbench la base de datos que se encuentra en la carpeta main\java\data
 
 
 ## **Iniciar**
 1. Iniciar el main de la clase Beginnig
 
 <img width="300" alt="image" src="https://user-images.githubusercontent.com/110065106/212447837-142764d4-84f6-46fe-877d-faf4121122b5.png">

 
 
      
  
   
   
   
   
   
   
  
  
  

 
 
 


   
