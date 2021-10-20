package ejerciciosClase.copyCaracteres;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyCaracteres {
    int contadorCaracteres;

    public void escribirCaracteres(File file) throws IOException {
        FileInputStream inputF = new FileInputStream(file);
        FileOutputStream outputF =new FileOutputStream("/home/oracle/Escritorio/texto2.txt");
        while ((contadorCaracteres = inputF.read()) != -1) {
            outputF.write(contadorCaracteres);
        }
        outputF.close();
        inputF.close();
    }
}
