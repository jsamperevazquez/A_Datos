package ejerciciosClase.serializacionDos;

import java.io.File;
import java.io.IOException;

public class Principal {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("/home/oracle/Escritorio/OtrosProductos.txt");
        Product producto1 = new Product();
        Product producto2 = new Product();
        Product producto3 = new Product();
        Product producto4 = null;
        Product metodos = new Product();
        Serial access = new Serial();
        Product[] listaProductos = new Product[4];
        listaProductos[0]= producto1;
        listaProductos[1]= producto2;
        listaProductos[2]= producto3;
        listaProductos[3]= producto4; // Meto el último objeto un nulo para dar la condición de fin al while del método en Serial
        metodos.escribirValores(file,listaProductos);
        access.escribirObjetos(file,listaProductos);


    }
}
