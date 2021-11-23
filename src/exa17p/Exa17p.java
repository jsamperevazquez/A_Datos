package exa17p;

import ejerciciosClase.baserelacionalA.Conexion;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Exa17p {
    private static int precio;
    private static int cantidad;
    private static int elemento;
    private static int gasto;
    private static String atrib = "";
    private static String atrib2 = "";
    private static String contenido = "";
    private static String fecha = "";
    private static String cantidade = "";

    public void hacerPedido(File file) throws FileNotFoundException, XMLStreamException, SQLException {
        Conexion conn = new Conexion();
        XMLInputFactory inpF = XMLInputFactory.newInstance();
        XMLStreamReader xml = inpF.createXMLStreamReader(new FileInputStream(file));
        Statement consulta = conn.conexion().createStatement();
        while (xml.hasNext()) {
            // Deben imprimirse los valores correspondientes a cada pedido
            if ((elemento = xml.getEventType()) == XMLStreamConstants.START_ELEMENT) {
                contenido = xml.getLocalName();
                if (contenido.equalsIgnoreCase("pedido")) {
                    atrib = xml.getAttributeValue(0);
                    atrib2 = xml.getAttributeValue(1);
                    System.out.println(atrib + " " + atrib2);
                } else if (contenido.equalsIgnoreCase("cantidade")) {
                    cantidade = xml.getElementText();
                    System.out.println(cantidade);
                    cantidad = Integer.parseInt(cantidade);
                    // El campo stock debe disminuir en la misma cantidad especificada en el elemento cantidad
                    PreparedStatement act = conn.conexion().prepareStatement("UPDATE produtos set stock = stock - ? where codigop = ?");
                    // Establezco valores a mis comodines ?
                    act.setInt(1, cantidad);
                    act.setString(2, atrib2);
                    act.execute();
                    ResultSet precioProducto = consulta.executeQuery("select prezo from produtos where codigop = '" + atrib2 + "'");
                    // mientras el resulSet tenga contenido:
                    while (precioProducto.next()) {
                        precio = precioProducto.getInt(1); // asigno a varible el valor recogido de mi consulta
                        gasto = precio * cantidad; // precio del producto por la cantidad comprada establecida en el xml

                        // Actualizo el campo gasto con su valor más el nuevo gasto
                        act = conn.conexion().prepareStatement("UPDATE clientes set gasto = gasto + ? where  codigoc = ?");
                        act.setInt(1, gasto);
                        act.setString(2, atrib);
                        act.execute();
                    }

                } else if (contenido.equalsIgnoreCase("data")) {
                    fecha = xml.getElementText();
                    System.out.println(fecha);
                    PreparedStatement insertarVendas = conn.conexion().prepareStatement("insert into vendas values (?,?,?,?)");
                    insertarVendas.setString(1, atrib);
                    insertarVendas.setString(2, atrib2);
                    insertarVendas.setString(3, fecha);
                    insertarVendas.setInt(4, gasto);
                    insertarVendas.execute();
                }
            }
            xml.next();
        }

    }
}
