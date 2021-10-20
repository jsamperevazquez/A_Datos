package ejerciciosClase.textoDelimitado;
import java.io.*;
import java.util.Arrays;

public class Textodelimitado {
    String[] cod = {"p1", "p2", "p3"};
    String[] descripcion = {"parafusos", "cravos", "tachas"};
    Double[] prezo = {3.0, 4.0, 5.0};


    @Override
    public String toString() {
        return
                Arrays.toString(cod) +
                        Arrays.toString(descripcion) +
                        Arrays.toString(prezo);


    }

    public Product escribirLeerTexto(Product producto) throws IOException {
        int contador = 0;
        String datosGrabdos = null;
        PrintWriter printF = new PrintWriter("/home/oracle/Escritorio/productos.txt");
        BufferedReader bufeF = new BufferedReader(new FileReader("/home/oracle/Escritorio/productos.txt"));
        for (int i = 0; i < cod.length; i++) {
            printF.println(cod[i] + "\t" + descripcion[i] + "\t" + prezo[i]);
        }
        printF.close();

        while ((datosGrabdos = bufeF.readLine()) != null) {
            String[] datosLeidos = datosGrabdos.split("\t");
            producto.setCodigo(datosLeidos[0]);
            producto.setDescripcion(datosLeidos[1]);
            producto.setPrezo(Double.parseDouble(datosLeidos[2]));



            /*

            for (String palabra : datosLeidos) {
                switch (contador) {
                    case 0:
                    case 3:
                    case 6:
                        producto.setCodigo(palabra);
                        break;
                    case 1:
                    case 4:
                    case 7:
                        producto.setDescripcion(palabra);
                        break;
                    case 2:
                    case 5:
                    case 8:
                        producto.setPrezo(Double.parseDouble(palabra));
                        break;

                }
                contador ++;
            }

             */
            System.out.println("Código: " + producto.getCodigo() +"\n" +
                    "Descripción: " + producto.getDescripcion() + "\n" +
                    "Prezo: " + producto.getPrezo() + " €");
        }

        bufeF.close();
        return producto;

    }
}