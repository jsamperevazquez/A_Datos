package ejerciciosClase.primitiveUtfChars;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("/home/oracle/Escritorio/text6.dat");

        PrimitiveUTFChars prueba = new PrimitiveUTFChars();
        prueba.escribirArchivo(file);
    }
}
