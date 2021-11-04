package ejerciciosClase.xmlProba;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class XmlProba  {

    public void crearXML(File file) throws IOException, XMLStreamException {

        XMLOutputFactory xml = XMLOutputFactory.newInstance();

        XMLStreamWriter xmlO = xml.createXMLStreamWriter(new FileWriter(file));
        xmlO.writeStartDocument("1.0");
        xmlO.writeStartElement("autores");
        xmlO.writeStartElement("autor");
        xmlO.writeAttribute("codigo","a1");
        xmlO.writeStartElement("nome");
        xmlO.writeCharacters("Alexandre Dumas");
        xmlO.writeEndElement();
        xmlO.writeStartElement("titulo");
        xmlO.writeCharacters("El conde de montecristo");
        xmlO.writeEndElement();
        xmlO.writeStartElement("titulo");
        xmlO.writeCharacters("Los miserables");
        xmlO.writeEndElement();
        xmlO.writeEndElement();
        xmlO.writeStartElement("autor");
        xmlO.writeAttribute("codigo","a2");
        xmlO.writeStartElement("nome");
        xmlO.writeCharacters("Fiodor Dostoyevski");
        xmlO.writeEndElement();
        xmlO.writeStartElement("titulo");
        xmlO.writeCharacters("El idiota");
        xmlO.writeEndElement();
        xmlO.writeStartElement("titulo");
        xmlO.writeCharacters("Noches blancas");
        xmlO.writeEndElement();
        xmlO.writeEndElement();
        xmlO.writeEndElement();
        xmlO.close();
    }

}
