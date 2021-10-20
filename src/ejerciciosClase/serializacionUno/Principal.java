package ejerciciosClase.serializacionUno;

import java.io.File;
import java.io.IOException;

public class Principal {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Mclase prueba = new Mclase();
        Mclase objAEscribir = new Mclase();
        prueba.nome = "hola";
        prueba.numero1 = -7;

        prueba.numero2 = 2.7E10;
        prueba.escribirObxeto(prueba,objAEscribir,new File("/home/oracle/Escritorio/serial.txt"));
    }
}
