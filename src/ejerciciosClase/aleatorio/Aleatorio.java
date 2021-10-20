package ejerciciosClase.aleatorio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Aleatorio {
    String[] codes = {"p1", "p2", "p3"};
    String[] descripcion = {"parafusos", "cravos", "tachas"};
    int[] prices = {3, 4, 5};
    int formula = (2 - 1) * 30; // formula para el seek(): (posición -1) * tamaño del registro en bytes
    String codigoLeido = "";
    String descripLeido = "";
    int precioLeido;

    public void lecEsc(File file, String modo) throws IOException {
        RandomAccessFile outF = new RandomAccessFile(file, modo);
        for (int i = 0; i < 3; i++) {
            outF.writeChars(String.format("%-" + 3 + "s", codes[i]).replace(' ', '0'));
            outF.writeChars(String.format("%-" + 10 + "s", descripcion[i]).replace(' ', '0'));
            outF.writeInt(prices[i]);
            System.out.println(prices[i]);
        }
        outF.seek(formula);
        for (int i = 0; i < 3; i++) {
            codigoLeido += outF.readChar();
        }
        codigoLeido = codigoLeido.replaceAll("0", ""); // vuelvo a quitar caracteres usados para tamaño fijo
        for (int i = 0; i < 10; i++) {
            descripLeido += outF.readChar();
        }
        descripLeido = descripLeido.replaceAll("0", "");

        precioLeido = outF.readInt();
        System.out.println(codigoLeido + descripLeido + precioLeido);
        outF.close();
    }

}
