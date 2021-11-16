package exa15brevep; // Ojo el paquete en serialización tiene que ser exactamente igual

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ejerciciosClase.baserelacionalA.Conexion;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

public class Exa15brevep implements Serializable {


    public void leerPlatos(Platos plato, File file, File file2) throws IOException, ClassNotFoundException, SQLException, XMLStreamException {
        XMLOutputFactory out = XMLOutputFactory.newInstance();
        XMLStreamWriter xml = out.createXMLStreamWriter(new FileWriter(file2));
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
        xml.writeStartDocument("1.0");
        while ((plato = (Platos) inpF.readObject()) != null) {
            xml.writeStartElement("Platos");
            xml.writeStartElement("Plato");
            xml.writeAttribute("codigo", plato.getCodigop());
            xml.writeStartElement("NomeP");
            xml.writeCharacters(plato.getNomep());
            xml.writeEndElement();

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
            xml.writeStartElement("GraxaTotal");
            System.out.println("Grasa total = " + grasaTotal + "\n");
            xml.writeCharacters(String.valueOf(grasaTotal));
            xml.writeEndElement();
            xml.writeEndElement();
            xml.writeEndElement();
            grasaTotal = 0; // Vuelvo a poner a cero la grasa total para que no sume la primera vuelta
        }

        inpF.close();
        xml.close();

    }
}