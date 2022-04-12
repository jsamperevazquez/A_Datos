package pvehiculos;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import ejerciciosClase.baserelacionalA.Conexion;
import mongo.ConexionMongo;
import mongo.MetodosMongo;
import org.bson.Document;
import org.bson.types.ObjectId;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Aplicacion extends ConexionMongo implements MetodosMongo {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/vehicli.odb");
    EntityManager em = emf.createEntityManager();
    EntityManager em2 = emf.createEntityManager();
    Conexion conn = new Conexion();
    List<Vehiculos> listaVehiculos;
    List<Clientes> listaClientes;
    Double precioFinal = 0.0;
    boolean descuento = false;

    public Aplicacion() throws SQLException {
    }

    public void tratarDatos() throws SQLException {
        Statement statement = conn.conexion().createStatement();
        FindIterable<Document> docs = coleccion.find();
        MongoCursor<Document> cursor = docs.iterator();
        while (cursor.hasNext()) {
            Document doc = cursor.next();
            Double Id = doc.getDouble("_id");
            String dni = doc.getString("dni");
            String codveh = doc.getString("codveh");
            System.out.println("id: " + Id + " DNI: " + dni + " Code: " + codveh);
            Query qw = em.createQuery("Select cliente from Clientes cliente where cliente.dni = '" + dni + "'");
            Query qw2 = em2.createQuery("Select vehiculo from Vehiculos vehiculo where vehiculo.codveh = '" + codveh + "'");
            listaClientes = qw.getResultList();
            listaVehiculos = qw2.getResultList();
            String nombreCliente = "";
            String nombreVehiculo = "";
            for (Clientes cl : listaClientes
            ) {
                System.out.println("Nombre: " + cl.getDni() + " Numero de compras: " + cl.getNcompras());
                nombreCliente = cl.getNomec();
                if (cl.getNcompras() > 0) {
                    descuento = true;
                }
                for (Vehiculos vh : listaVehiculos
                ) {
                    System.out.println("Nombre: " + vh.getNomveh() + " Ano matricula: " + vh.getAnomatricula() + " Precio origen: " + vh.getPrezoorixe());
                    nombreVehiculo = vh.getNomveh();
                    if (descuento) {
                        precioFinal = (vh.getPrezoorixe() - ((2019d - vh.getAnomatricula()) * 500) - 500);
                        descuento = false;
                    } else
                        precioFinal = (vh.getPrezoorixe() - ((2019d - vh.getAnomatricula()) * 500));

                    System.out.println("Precio final= " + precioFinal);
                    String insert = "insert into finalveh values(" + Id + ",'" + dni + "', '" + nombreCliente + "',('" + nombreVehiculo + "'," + precioFinal + "));";
                    statement.executeUpdate(insert);
                }
            }


        }
        em.close();
        em2.close();
        emf.close();
        statement.close();
    }
}
