package ejerciciosClase.serializacionDos;

import java.io.*;

public class Serial implements Serializable {

    public void escribirObjetos(File file, Product[] productos) throws IOException, ClassNotFoundException {
        ObjectOutputStream outF = new ObjectOutputStream(new FileOutputStream(file));
        ObjectInputStream inpF = new ObjectInputStream(new FileInputStream(file));
        for (int i = 0; i < productos.length; i++) {
            outF.writeObject(productos[i]);
        }
        outF.close();
        Product pr = null; // Declaro un Product con valor nulo para ir dando los valores de cada objeto grabado en fichero, y saber cuando llega al nulo.
        while ((pr = (Product) inpF.readObject()) != null){
            System.out.println(pr);
        }
    }
    }