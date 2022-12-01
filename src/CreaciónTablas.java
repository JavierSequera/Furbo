import java.sql.Connection;
import java.sql.Statement;

public class CreaciónTablas {
    public static void main(String[] args) {
        try{
            MétodosDB.CrearTabla("Equipos", new String[]{"idEquipo int AUTO_INCREMENT", "nombre varchar(25)", "ganados int",
                    "perdidos int", "golesMarcados int", "golesRecibidos int", "PRIMARY KEY (idEquipo, nombre)"});
            MétodosDB.CrearTabla("Octavos", new String[]{"idEquipoA int", "idEquipoB int", "golesA int",
                    "golesB int","PRIMARY KEY (idEquipoA, idEquipoB)", "FOREIGN KEY (idEquipoA) REFERENCES Equipos (idEquipo)",
                    "FOREIGN KEY (idEquipoB) REFERENCES Equipos (idEquipo)"});
            MétodosDB.CrearTabla("Cuartos", new String[]{"idEquipoA int", "idEquipoB int", "golesA int",
                    "golesB int","PRIMARY KEY (idEquipoA, idEquipoB)",
                    "FOREIGN KEY (idEquipoA) REFERENCES Equipos (idEquipo)",
                    "FOREIGN KEY (idEquipoB) REFERENCES Equipos (idEquipo)"});
            MétodosDB.CrearTabla("Semifinal", new String[]{"idEquipoA int", "idEquipoB int", "golesA int",
                    "golesB int","PRIMARY KEY (idEquipoA, idEquipoB)", "FOREIGN KEY (idEquipoA) REFERENCES Equipos (idEquipo)",
                    "FOREIGN KEY (idEquipoB) REFERENCES Equipos (idEquipo)"});
            MétodosDB.CrearTabla("Final", new String[]{"idEquipoA int", "idEquipoB int", "golesA int",
                    "golesB int","PRIMARY KEY (idEquipoA, idEquipoB)", "FOREIGN KEY (idEquipoA) REFERENCES Equipos (idEquipo)",
                    "FOREIGN KEY (idEquipoB) REFERENCES Equipos (idEquipo)"});
        }catch (Exception ex){
            throw ex;
        }
    }
}
