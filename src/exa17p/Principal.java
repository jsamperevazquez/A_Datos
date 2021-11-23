package exa17p;

import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;

public class Principal {
    public static void main(String[] args) throws XMLStreamException, FileNotFoundException, SQLException {
        File file = new File("/home/oracle/Descargas/pedidos.xml");
        Exa17p prueba = new Exa17p();
        prueba.hacerPedido(file);
    }
}
