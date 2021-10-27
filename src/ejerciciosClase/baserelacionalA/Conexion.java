package ejerciciosClase.baserelacionalA;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Conexion {
    String driver = "jdbc:postgresql:";
    String host = "//localhost:"; // tamen poderia ser una ip como "192.168.1.14"
    String porto = "5432";
    String sid = "postgres";
    String usuario = "oracle";
    String password = "oracle";
    String url = driver + host+ porto + "/" + sid;
    Connection conn = DriverManager.getConnection(url,usuario,password);
    public Conexion() throws SQLException {
    }


    public Connection conexion() throws SQLException {

      return conn;
    }
    public void insertarProducto(String codigo, String nombre, float precio, String fechaCaducidad) throws SQLException {
        // Creo un objeto de tipo SimpleDateFormat para poder asignar el formato deseado
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        // Declaro un tipo Date nulo para poder asignarlo después
        Date fecha = null;
        try {
            fecha = df.parse(fechaCaducidad); // asigno a fecha el objeto df parseado con el String que recibo en método
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime()); // Creo una fecha de SQL que lo requiere el PreparedStatement y le paso como parametro el date.getTime()

        PreparedStatement insertar = conn.prepareStatement("INSERT INTO produtos values (?,?,?,?)");
        insertar.setString(1,codigo);
        insertar.setString(2,nombre);
        insertar.setFloat(3,precio);
        insertar.setDate(4,fechaSQL);
        insertar.execute();
    }
}
