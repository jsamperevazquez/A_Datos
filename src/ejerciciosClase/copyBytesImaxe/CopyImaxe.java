package ejerciciosClase.copyBytesImaxe;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Creado por @autor: Usuario
 * El 29/09/2021
 **/
public class CopyImaxe {
    FileInputStream arquivo;
    FileOutputStream copiaArquivo;

    {
        try {
            arquivo = new FileInputStream("C:\\Users\\Usuario\\OneDrive\\Escritorio\\foto.jpg");
            copiaArquivo = new FileOutputStream("C:\\Users\\Usuario\\OneDrive\\Escritorio\\foto2.jpg",true);
            // La copia ocupa lo mismo que la original en la primera ejecución
            // Después es MB ^ veces ejecución app
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo non encontrado");
        }
    }

    public void copiarArquivo() {
        try {
            int contido;
            while ((contido = arquivo.read()) != -1) {
                copiaArquivo.write(contido);
            }
            copiaArquivo.close();
        } catch (IOException e) {
            System.out.println("Error en lectura archivo");

        }
    }
}
