package ejerciciosClase.aleatorio;

import java.io.File;
import java.io.IOException;

public class Principal {
    public static void main(String[] args) throws IOException {
        Aleatorio prueba = new Aleatorio();
        File file = new File("/home/oracle/Escritorio/aleatorio.txt");
        prueba.lecEsc(file,"rw");
    }
}
