package ejerciciosClase.writeChars;

import java.io.*;

public class WriteChars {
    String cadena = "o tempo está xélido";
    int bytesRestantes;
    String nuevaCadena = "";
    int numeroDeCadenas = 2;

    public void leerChar(File file) throws IOException {
        DataOutputStream outputArchivo = new DataOutputStream(new FileOutputStream(file));
        DataInputStream inputArchivo = new DataInputStream(new FileInputStream(file));
        for (int i = 0; i < numeroDeCadenas; i++) {
            outputArchivo.writeChars(cadena);
            System.out.println("Escribindo: " + cadena);
            System.out.println("Longitud de la cadena es de " + cadena.length() + " Bytes");
            System.out.println("Se lleva escrito: " + outputArchivo.size());
        }
        outputArchivo.close();
        while ((bytesRestantes = inputArchivo.available()) != 0) {
            for (int i = 0; i < (cadena.length()); i++) {
                Character caracter = inputArchivo.readChar();
                nuevaCadena += caracter.toString();
            }
            System.out.println("Leemos la cadena: " + nuevaCadena);
            bytesRestantes = inputArchivo.available();
            System.out.println("Restan por leer: " + (bytesRestantes) + " Bytes");
        }
        inputArchivo.close();
    }


}
