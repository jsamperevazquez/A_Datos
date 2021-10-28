package ejerciciosClase.baserelacionalA;

import java.sql.SQLException;
import java.util.Date;


public class baseRelacional {
    public static void main(String[] args) {
        try {
            Conexion con = new Conexion();
            con.conexion();
            /*
            con.insertarProducto("p1","parafusos",3.0F, "27/12/2020");
            con.insertarProducto("p2","cravos",4.0F, "06/04/2020");
            con.insertarProducto("p3","tachas",3.0F, "03/07/2020");

             */
            con.actualizaPrecio("p2",8.0F);
            con.eliminarProducto("p3");
            con.listaProductos();
        } catch (SQLException e) {
            System.out.println("Error en la conexión" + e.getMessage());
        }
    }
}
