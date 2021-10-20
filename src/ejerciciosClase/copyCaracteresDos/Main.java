package ejerciciosClase.copyCaracteresDos;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("/media/sf_compartida/texto1.txt");
        CopyCaracteres2 prueba = new CopyCaracteres2();
        prueba.copyCaracteres(file);
    }
}
