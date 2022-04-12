package pinvasoras1;

import java.sql.SQLException;

public class Principal {
    public static void main(String[] args) throws SQLException {
        Logica app = new Logica();
        app.conectar_servidor();
        app.conectar_base("test");
        app.apuntar_coleccion("encontradas");
        app.mostrarDatos("$objectdb/db/zonas.odb");
    }
}
