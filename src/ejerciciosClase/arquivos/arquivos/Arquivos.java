package ejerciciosClase.arquivos.arquivos;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Creado por @autor: Usuario
 * El 23/09/2021
 **/
public class Arquivos {

    public void eDirectorio(String cadea){
        File directorio = new File(cadea);
        // isDirectory() que devuelve booleano si es o no directorio
        if (directorio.isDirectory()){
            System.out.println("e un directorio");
        }
        else {
            System.out.println("Non e un directorio");
        }
    }
    public void eFicheiro(String cadea){
        File ficheiro = new File(cadea);
        //isFile() que devuelve booleano si es o no directorio
        if (ficheiro.isFile()){
            System.out.println("É un ficheiro");
        }
        else {
            System.out.println("Non é ficheiro");
        }
    }
    public void creaDirectorio(String string) throws Exception {
        File directorio = new File(string);
        if (!directorio.exists()){ // si el directorio no existe
            // Uso Mkdirs() en lugar de mkdir para poder crear subdirectorios
            directorio.mkdirs();
            System.out.println("Directorio creado satisfactoriamente");
        }
        // Creo una excepción personalizada que salte si ya existe el directorio
        else throw new Exception("Directorio ya existe");
    }
    public void creaFicheiro(String dirName, String fileName) throws Exception {
        File directorio = new File(dirName);
        if (directorio.exists()){ // si el directorio existe
            File arquivo = new File(dirName + fileName);
            try {
                if (arquivo.createNewFile())
                    System.out.println("o ficheiro creouse correctamente");
                else
                    System.out.println("Non ha podido ser creado o ficheiro");
            } catch (Exception e) {
                e.getMessage();
            }
            // Creo una excepción personalizada que salte si no existe el directorio
        }else throw new Exception("Directorio no existe");

    }
    public void modoAcceso(String dirname, String fileName){
        File archivo = new File(dirname,fileName);
        if (archivo.exists()){
            if (archivo.canWrite()){
                System.out.println("Escritura sí");
            }else System.out.println("Escritura non");
            if (archivo.canRead()){
                System.out.println("Lectura sí");
            }else System.out.println("Lectura no");
        }else System.out.println("Fichero no existe");
    }
    public void calculaLonxitude(String dirname, String fileName){
        File archivo = new File(dirname,fileName);
        if (archivo.exists()){
            System.out.println(archivo.length() + " bytes");
        }else System.out.println("Fichero no existe");
    }
    public void mLectura(String dirname, String fileName){
        File archivo = new File(dirname,fileName);
        if (archivo.exists()){
            archivo.setReadOnly();
            System.out.println("Ficheiro " + fileName + " pasa a ser solo lectura");
        }else System.out.println("Fichero no existe");
    }
    public void mEscritura(String dirname, String fileName){
        File archivo = new File(dirname,fileName);
        if (archivo.exists()) {
            archivo.setWritable(true);
            System.out.println("Ficheiro " + fileName + " pasa a ser lectura y escritura");
        }else System.out.println("Fichero no existe");
    }
    public void borraFichero(String dirname, String fileName){
        File archivo = new File(dirname,fileName);
        if (archivo.exists()) {
            archivo.delete();
            System.out.println("Fichero " + fileName + " ha sido borrado");
        }else System.out.println("Fichero no existe");
    }
    public void borraDirectorio(String dirName){
        File directorio = new File(dirName);
        if (directorio.exists()) {
            directorio.delete();
            System.out.println("Directorio borrado");
        }else System.out.println("Ruta inexistente ou con descendencia");
    }

    public void mContido(String dirName) throws Exception{
        File directorio = new File(dirName);
        if (directorio.exists()) {
            // Creo array de String para insertar los ficheros
            String[] listado = directorio.list();
            if (listado == null || listado.length == 0) {
                System.out.println("No hay elementos dentro de la carpeta actual");
                return;
            } else {
                System.out.println("Arquivos no directorio: ");
                for (int i = 0; i < listado.length; i++) {
                    System.out.println(listado[i]);
                }
            }
        }else throw new Exception("Directorio no existe");
    }
}