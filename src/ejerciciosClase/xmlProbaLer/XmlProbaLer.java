package ejerciciosClase.xmlProbaLer;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class XmlProbaLer {

    public void leerXml(File file) throws FileNotFoundException, XMLStreamException {
        XMLInputFactory inpXml = XMLInputFactory.newInstance();
        XMLStreamReader xml = inpXml.createXMLStreamReader(new FileInputStream(file));
        int elemento = 0;
        String contenido = "";
        String nombre = "";
        while (xml.hasNext()) {
            if ((elemento = xml.getEventType()) == XMLStreamConstants.START_ELEMENT) {
                contenido = xml.getLocalName();
                String atr = xml.getAttributeValue(0);
                if (contenido.equalsIgnoreCase("autor")){
                    System.out.println(atr);
                }
                else if (contenido.equalsIgnoreCase("nome")) {
                    nombre = xml.getElementText();
                    System.out.println(nombre);
                }else if (contenido.equalsIgnoreCase("titulo")){
                    nombre = xml.getElementText();
                    System.out.println(nombre);
                }

            }
            xml.next();

        }
        xml.close();
    }
}
