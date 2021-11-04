package exa15brevep; // Ojo el paquete en serialización tiene que ser exactamente igual

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ejerciciosClase.baserelacionalA.Conexion;

public class Exa15brevep implements Serializable {


    public void leerPlatos(Platos plato, File file) throws IOException, ClassNotFoundException, SQLException {
        Conexion conn = new Conexion();
        plato = null;
        ObjectInputStream inpF = new ObjectInputStream(new FileInputStream(file));
        conn.conexion();
        int peso = 0;
        int graxa = 0;
        int graxaParcial = 0;
        int grasaTotal = 0;
        String codC = "";
        Statement consulta = conn.conexion().createStatement();

        Statement consulta2 = conn.conexion().createStatement();
        while ((plato = (Platos) inpF.readObject()) != null) {
            System.out.println(plato);
            ResultSet r = consulta.executeQuery("SELECT codc,peso from composicion where codp ='" + plato.getCodigop()+ "'" );
            while (r.next()) {
                codC = r.getString(1);
                peso = r.getInt(2);
                ResultSet r2 = consulta2.executeQuery("SELECT graxa from componentes where codc = '" + codC + "'"); // Segunda consulta en función de el codc que devuelva la primera

                while (r2.next()) {
                    graxa = r2.getInt(1);
                    graxaParcial = (peso /100) * graxa;
                    grasaTotal += graxaParcial;
                }
            }
            System.out.println("Grasa total = " + grasaTotal + "\n");
            grasaTotal = 0; // Vuelvo a poner a cero la grasa total para que no sume la primera vuelta
        }

        inpF.close();

    }
}