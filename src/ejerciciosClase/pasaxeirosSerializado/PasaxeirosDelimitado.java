package ejerciciosClase.pasaxeirosSerializado;

import java.io.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

import ejerciciosClase.baserelacionalA.Conexion;

public class PasaxeirosDelimitado {
    Conexion conn = new Conexion();
    PreparedStatement insertar = conn.conexion().prepareStatement("insert into reservasfeitas values(?,?,?,?)"); // PreparedStatment para hacer inserciones en las tablas
    Statement consulta = conn.conexion().createStatement(); // Statement para crear consultas de tipo select
    Statement consulta2 = conn.conexion().createStatement();

    public PasaxeirosDelimitado() throws SQLException {
    }

    public void leerReservas(File file) throws IOException, SQLException {
        // Declaro variables para asignar valores que vaya leyendo (Todos String porque readline devuelve String)
        String valor = null;
        String nome = "";
        String codR = "";
        String dni = "";
        String idVooIda = "";
        String idVooVolta = "";
        int precioVuelo = 0;
        BufferedReader inpS = new BufferedReader(new FileReader(file)); // Instancio objeto de tipo BufferReader para poder usar readline con split para delimitar por caracter
        ResultSet r; // Creo los resulset para poder recoger los resultados de las consultas.
        ResultSet r2;
        System.out.println("Reservas: ");
        while ((valor = inpS.readLine()) != null) { // Mientras no devuelva un null (readline devuelve un null cuando termina las filas)
            String[] valores = valor.split(","); // Corto por las , que delimitan los campos del txt
            for (int i = 0; i < 4; i++) { // Abro un bucle del mismo tamaño como campos tiene la fila leida.
                // Asigno a cada variable el valor leido correspondiente
                codR = valores[0];
                dni = valores[1];
                idVooIda = valores[2];
                idVooVolta = valores[3];
            }
            r = consulta.executeQuery("select nome from pasaxeiros where dni = '" + dni + "'");  // Ejecuto la consulta y se la asigno a resulset
            while (r.next()) {
                r2 = consulta2.executeQuery("select sum(prezo) from voos where voo='" + idVooIda + "'" + "or voo= '" + idVooVolta + "'"); // Hago consulta sumando cuando hay un número de ida y otro de vuelta(si no tendría que hacer una tercera consulta, una para idvooida y otra para idvoovolta)
                nome = r.getString(1); // asigno a nome el valor que recojo del campo nome de la consulta select pasando el número de columna
                insertar.setString(3, nome); // Inserto el valor de nome en la columna correspondiente
                while (r2.next()) { // Abro bucle para la segunda consulta
                    precioVuelo = r2.getInt(1); // Asigno a precio de vuelo el valor suma de la consulta r2
                    insertar.setInt(4, precioVuelo); // Inserto el valor en la columna correspondiente
                }
                r2.next(); // Pasamos al siguiente en consulta r2
            }
            insertar.setInt(1, Integer.parseInt(codR));
            insertar.setString(2, dni);
            insertar.execute();
            System.out.println(codR + " " + dni + " " + idVooIda + " " + idVooVolta);
            r.next();
        }
        // Cerramos flujos
        insertar.close();
        inpS.close();
    }
}
