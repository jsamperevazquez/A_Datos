package pinvasoras1;

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

public class Logica extends ConexionMongo implements MetodosMongo {
    EntityManagerFactory emf = null;
    EntityManager em = null;
    static List<Zonas> listaZonas;
    static double totalZonaDanada;
    static double totalExemplares;
    static double parcial;
    Conexion conn = new Conexion();

    public Logica() throws SQLException {
    }

    @Override
    public void consultarCampoValor(String campo, Object valor) throws SQLException {
        Statement st = conn.conexion().createStatement();
        BasicDBObject condition = new BasicDBObject(campo, valor);
        FindIterable<Document> doc = coleccion.find(condition);
        MongoCursor<Document> cursor = doc.iterator();
        Double extensionDanada;
        Double exemplaresMetro;
        Double codz = 0.0;
        while (cursor.hasNext()){
            Document document = cursor.next();
            codz = document.getDouble("codz");
            extensionDanada = document.getDouble("extensiondanada");
            exemplaresMetro = document.getDouble("exemplaresmetro");
            System.out.println("Extension danada: " + extensionDanada + " Ejemplares por metro: " + exemplaresMetro);
            parcial = extensionDanada * exemplaresMetro;
            totalZonaDanada += extensionDanada;
            totalExemplares += parcial;
            parcial = 0;
        }
        System.out.println("Total zona danada = " + totalZonaDanada );
        System.out.println("Total de exemplares = " + totalExemplares + "\n");
        totalZonaDanada = 0;
        totalExemplares = 0;
    }

    public void mostrarDatos(String bdODB) throws SQLException {
        emf = Persistence.createEntityManagerFactory(bdODB);
        em = emf.createEntityManager();

        Query query1 = em.createQuery("SELECT zona FROM Zonas zona", Zonas.class);
        listaZonas = query1.getResultList();
        System.out.println("Consulta de BD ODB");
        for (Zonas z : listaZonas
        ) {
            System.out.println("Código zona: " + z.getCodz() + " Nombre zona: " + z.getNomz() + " Superficie: " + z.getSuperficie());
            this.consultarCampoValor("codzona", z.getCodz());
        }
    }
}
