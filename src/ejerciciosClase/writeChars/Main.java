package ejerciciosClase.writeChars;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("/home/oracle/Escritorio/texto5.dat");

        WriteChars objeto = new WriteChars();
        objeto.leerChar(file);

    }
}
