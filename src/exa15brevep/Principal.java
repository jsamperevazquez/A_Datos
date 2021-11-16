package exa15brevep;
import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;

public class Principal implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException, XMLStreamException {
        File file = new File("platoss");
        File file2 = new File("xmlPlatos");
        Exa15brevep prueba = new Exa15brevep();
        Platos plato = new Platos();
        prueba.leerPlatos(plato,file,file2);


    }
}