package ejerciciosClase.copyBytesTexto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Creado por @autor: Usuario
 * El 28/09/2021
 **/
public class Arquivos {
    FileInputStream arquivo;
    FileOutputStream copiaArquivo;

    {
        try {
            arquivo = new FileInputStream("C:\\Users\\Usuario\\OneDrive\\Escritorio\\texto1.txt");
            copiaArquivo = new FileOutputStream("C:\\Users\\Usuario\\OneDrive\\Escritorio\\texto2.txt", true);
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
            arquivo.close();
        } catch (IOException e) {
            System.out.println("Error en lectura archivo");

        }
    }
}
