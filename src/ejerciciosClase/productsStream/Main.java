package ejerciciosClase.productsStream;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("/home/oracle/Escritorio/productos.txt");
        Product product = new Product("cod1", "parafusos", 3.0);
        Product product1 = new Product("cod2","cravos", 4.0);
        Product po3 = new Product();
        product.escribirValores(file, product);
        po3.escribirVacios(file,po3);
        product1.escribirValores(file,product1);
        po3.escribirVacios(file,po3);
        product.leerValores(file);



    }

}
