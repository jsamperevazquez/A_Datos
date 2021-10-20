package ejerciciosClase.textoDelimitado;

import java.io.*;

public class Product {
    private String codigo;
    private String descripcion;
    private Double prezo;

    public Product() {
        this.codigo = "";
        this.descripcion = "";
        this.prezo = 0.00;

    }

    public Product(String codigo, String descripcion, Double prezo) {
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

    public void setPrezo(Double prezo) {
        this.prezo = prezo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Double getPrezo() {
        return prezo;
    }

    @Override
    public String toString() {
        return codigo + descripcion + prezo;
    }

    public void escribirValores(File file, Product product) throws IOException {
        DataOutputStream outputF = new DataOutputStream(new FileOutputStream(file,true));
        outputF.writeUTF(product.codigo);
        outputF.writeUTF(product.descripcion);
        outputF.writeDouble(product.prezo);
        outputF.close();
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
        product.setPrezo(inputF.readDouble());
        System.out.println(product);
    }
}