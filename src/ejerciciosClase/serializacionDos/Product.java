package ejerciciosClase.serializacionDos;

import java.io.*;

public class Product implements Serializable {
    private String codigo;
    private String descripcion;
    private int prezo;
    String[] cod = {"p1", "p2", "p3"};
    String[] desc = {"parafusos", "cravos ", "tachas"};
    int[] precio = {3, 4, 5};

    public Product() {
        this.codigo = "";
        this.descripcion = "";
        this.prezo = 0;

    }


    public Product(String codigo, String descripcion, int prezo) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.prezo = prezo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrezo(int prezo) {
        this.prezo = prezo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getPrezo() {
        return prezo;
    }

    @Override
    public String toString() {
        return codigo + descripcion + (int) prezo;
    }

    public Product[] escribirValores(File file, Product[] productos) throws IOException {
        for (int i = 0; i < productos.length; i++) {
            if (productos[i] == null) {
                productos[i] = null;
            } else {
                productos[i].setCodigo(cod[i]);
                productos[i].setDescripcion(desc[i]);
                productos[i].setPrezo(precio[i]);
            }
        }
        return productos;
    }

    public void leerValores(File file) throws IOException {
        int contador;
        DataInputStream inputF = new DataInputStream(new FileInputStream(file));
        while ((contador = inputF.available()) != 0) {
            System.out.println(inputF.readUTF());
            System.out.println(inputF.readUTF());
            System.out.println(inputF.readDouble());
        }
        inputF.close();
    }

    public void escribirVacios(File file, Product product) throws IOException {
        int contador;
        DataInputStream inputF = new DataInputStream(new FileInputStream(file));
        product.setCodigo(inputF.readUTF());
        product.setDescripcion(inputF.readUTF());
        product.setPrezo(inputF.readInt());
        System.out.println(product);
    }
}

