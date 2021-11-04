package ejerciciosClase.xmlProba;

import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.IOException;

public class Principal {
    public static void main(String[] args) throws XMLStreamException, IOException {
    XmlProba proba = new XmlProba();
    File file = new File("/home/oracle/Escritorio/xmlproba0.xml");
    proba.crearXML(file);
    }
}
