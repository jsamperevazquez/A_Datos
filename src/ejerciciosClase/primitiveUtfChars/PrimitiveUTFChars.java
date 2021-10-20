package ejerciciosClase.primitiveUtfChars;

import java.io.*;

public class PrimitiveUTFChars {
    String cadena = "Está en casa";
    int bytesRestantes;
    String nuevaCadena = "";

    public void escribirArchivo(File file) throws IOException {
        DataOutputStream outputF = new DataOutputStream(new FileOutputStream(file));
        DataInputStream inputF = new DataInputStream(new FileInputStream(file));
        for (int i = 0; i < 3; i++) {
            if (i == 1)
                outputF.writeChars(cadena);
            else
                outputF.writeUTF(cadena);
        }
        outputF.close();


        while ((bytesRestantes = inputF.available()) != 0) {
            System.out.println(inputF.readUTF());
            System.out.println(bytesRestantes);

            for (int j = 0; j < cadena.length(); j++) {
                nuevaCadena += inputF.readChar();
            }
            bytesRestantes = inputF.available();
            System.out.println(nuevaCadena);
            System.out.println(bytesRestantes);
            System.out.println(inputF.readUTF());
            bytesRestantes = inputF.available();
            System.out.println(bytesRestantes);

        }
        inputF.close();

    }
}

