package ejerciciosClase.primitiveWriteUtf;

import java.io.*;

/**
 * Creado por @autor: Usuario
 * El 29/09/2021
 **/
public class Metodos {
    FileInputStream ficheiroLeido;
    String cadena = "o tempo está xélido";
    int contador;

    public void escribirArquivo() {
        try {
            DataOutputStream arquivoCreado = new DataOutputStream(new FileOutputStream(new File("C:\\Users\\Usuario\\OneDrive\\Escritorio\\texto3.txt"),true));
            DataInputStream arquivoLeido = new DataInputStream(new FileInputStream(new File("C:\\Users\\Usuario\\OneDrive\\Escritorio\\texto3.txt")));
            for (int i = 0; i < 3 ; i++) {
                arquivoCreado.writeUTF(cadena);
            }
            arquivoCreado.close();
            while ((contador = arquivoLeido.available()) != 0){
                contador = arquivoLeido.available();
                System.out.println("Escribiendo a cadea: " + arquivoLeido.readUTF() + "\nBytes por leer: " + (contador) );
            }
            System.out.println("\nLectura de arquivo terminado");
        } catch (IOException e) {
            System.out.println("Error en proceso " + e.getMessage());

        }
    }
}

