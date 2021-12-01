package pasaxeirosvoosserializadooracle_3;

import java.io.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ejerciciosClase.baserelacionalA.Conexion;

public class Pasaxeirosvoosserializadooracle3 implements Serializable {
    private static int acumuladorPrecio;

    public void leerReserva(Reserva reserva, File file) throws IOException, SQLException, ClassNotFoundException {
        ObjectInputStream inpS = new ObjectInputStream(new FileInputStream(file));
        Conexion conn = new Conexion();
        PreparedStatement actualizar = conn.conexion().prepareStatement("update pasaxeiros set nreservas = nreservas +1 where dni= ?");
        PreparedStatement insertar = conn.conexion().prepareStatement("insert into reservasfeitas values(?,?,?,?)");
        Statement consulta = conn.conexion().createStatement();
        Statement consulta2 = conn.conexion().createStatement();


        while ((reserva = (Reserva) inpS.readObject()) != null) {
            System.out.println(reserva.getCodr() + " " + reserva.getDni() + " " + reserva.getIdvooida() + " " + reserva.getIdvoovolta());
            ResultSet r1 = consulta.executeQuery("select nome from pasaxeiros where dni = '" + reserva.getDni() + "'");
            actualizar.setString(1, reserva.getDni());
            actualizar.execute();
            insertar.setInt(1, reserva.getCodr());
            insertar.setString(2, reserva.getDni());
            while (r1.next()) {
                ResultSet r2 = consulta2.executeQuery("select sum(prezo) from voos where  voo='" + reserva.getIdvooida() + "' or voo='" + reserva.getIdvoovolta() + "'");
                insertar.setString(3, r1.getString(1));
                while (r2.next()) {
                    acumuladorPrecio = r2.getInt(1);
                    insertar.setInt(4, acumuladorPrecio);
                    insertar.execute();
                }
            }
        }

    }
}
