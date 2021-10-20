package ejerciciosClase.copyCaracteresDos;

import java.io.*;

public class CopyCaracteres2 {
    int contadorCaracteres;
    String nuevaCadena = "";

    public void copyCaracteres(File file) throws IOException {
        BufferedReader bufR = new BufferedReader(new FileReader(file));
        PrintWriter printW = new PrintWriter("/home/oracle/Escritorio/texto2.txt");
        while ((nuevaCadena = bufR.readLine()) != null){
            System.out.println(nuevaCadena);
            printW.println(nuevaCadena);
        }
        printW.flush();
        bufR.close();
    }
}
