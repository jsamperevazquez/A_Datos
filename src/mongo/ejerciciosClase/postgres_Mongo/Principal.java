package mongo.ejerciciosClase.postgres_Mongo;

import org.bson.Document;
import org.bson.types.ObjectId;

import java.math.BigInteger;
import java.sql.SQLException;

public class Principal {
    public static void main(String[] args) throws SQLException {
        Reservas reserva = new Reservas();

        //conecto a la base de datos:
        reserva.conectar_servidor();
        reserva.conectar_base("reservas");
        reserva.apuntar_coleccion("reserva");
        //Converting string to character array

        //Ingreso los datos en Mongo con el método reservaAvion:
        //reserva.reservaAvion("1","361a",1.0,2.0,0.0,0.0);
        //reserva.reservaAvion("2","362b",3.0,4.0,0.0,0.0);
        //reserva.reservaAvion("3","361a",5.0,6.0,0.0,0.0);

        //Realizo auctualización:
        reserva.confirmar(new ObjectId("61f9cae83692270ef8e96f35"));
    }

}
