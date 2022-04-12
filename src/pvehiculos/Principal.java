package pvehiculos;

import java.sql.SQLException;

public class Principal {
    public static void main(String[] args) throws SQLException {
        Aplicacion app = new Aplicacion();
        app.conectar_servidor();
        app.conectar_base("test");
        app.apuntar_coleccion("vendas");
        app.tratarDatos();
    }
}
