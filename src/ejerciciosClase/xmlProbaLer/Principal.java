package ejerciciosClase.xmlProbaLer;

import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.FileNotFoundException;

public class Principal {
    public static void main(String[] args) throws XMLStreamException, FileNotFoundException {
        File file = new File("/home/oracle/Escritorio/xmlproba0.xml");
        XmlProbaLer xml = new XmlProbaLer();
        xml.leerXml(file);

    }
}
