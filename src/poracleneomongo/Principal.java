package poracleneomongo;

import java.sql.SQLException;

public class Principal {
    public static void main(String[] args) throws SQLException {

        Aplicacion app = new Aplicacion();
        app.conectar_servidor();
        app.conectar_base("bmongo");
        app.apuntar_coleccion("totalgraxas");
        app.tratarDatos();
        app.cerrarConexion();
    }
}
