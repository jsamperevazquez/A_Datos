package ejerciciosClase.pasaxeirosSerializado;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class Principal {
    public static void main(String[] args) throws IOException, SQLException {
        PasaxeirosDelimitado prueba = new PasaxeirosDelimitado();
        File file = new File("/home/oracle/Descargas/reservas.txt");
        prueba.leerReservas(file);
    }
}
