package pasaxeirosvoosserializadooracle_3;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class Principal {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        Pasaxeirosvoosserializadooracle3 prueba = new Pasaxeirosvoosserializadooracle3();
        Reserva reserva = new Reserva();
        File file = new File("reservas");
        prueba.leerReserva(reserva,file);
    }
}
