package ejerciciosClase.copyBytesImaxeDos;

import java.io.*;

/**
 * Creado por @autor: Usuario
 * El 29/09/2021
 **/
public class CopyImaxe2 {

    BufferedInputStream comprobarVelocidadeLectura;
    BufferedOutputStream getComprobarVelocidadeEscritura;
    FileInputStream arquivo;
    FileOutputStream copiaArquivo;


    {
        try {
            arquivo = new FileInputStream("C:\\Users\\Usuario\\OneDrive\\Escritorio\\foto.jpg");
            copiaArquivo = new FileOutputStream("C:\\Users\\Usuario\\OneDrive\\Escritorio\\foto2.jpg", true);
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo non encontrado");
        }
    }

    public void copiarArquivo() {
        // con BufferedStream duplicamos velocidades.
        try {
            comprobarVelocidadeLectura = new BufferedInputStream(arquivo);
            getComprobarVelocidadeEscritura = new BufferedOutputStream(copiaArquivo);
            int contido;
            while ((contido = comprobarVelocidadeLectura.read()) != -1) {
                getComprobarVelocidadeEscritura.write(contido);
            }
            getComprobarVelocidadeEscritura.close();
        } catch (IOException e) {
            System.out.println("Error en lectura archivo");

        }
    }
}