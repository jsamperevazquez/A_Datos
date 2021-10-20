package ejerciciosClase.copyCaracteres;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("/media/sf_compartida/texto1.txt");
        CopyCaracteres prueba = new CopyCaracteres();
        prueba.escribirCaracteres(file);
    }
}
