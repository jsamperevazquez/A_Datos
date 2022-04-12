package pinvasoras1Original;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
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

import ejerciciosClase.baserelacionalA.Conexion;

public class Metodos extends ConexionMongo implements MetodosMongo {
    ConexionMongo conn = new ConexionMongo();
    private static ObjectId id;
    BasicDBObject condition;
    FindIterable<Document> documents;
    MongoCursor<Document> cursor;
    // ObjectDB
    public List<Zonas> mostrarDatosTabla() {
        // Abrimos conexión a BD
        // Si no existe la crea
        EntityManagerFactory emc = Persistence.createEntityManagerFactory("$objectdb/db/zonas.odb");
        EntityManager em = emc.createEntityManager();
        // Creamos la Query
        Query query1 = em.createQuery("select zona from Zonas zona", Zonas.class);
        List<Zonas> listaZonas = query1.getResultList();
        return listaZonas;
    }
    // Mongo
    @Override
    public void consultarCampoValor(String campo, Object valor) {
        condition = new BasicDBObject(campo, valor);
        documents = coleccion.find(condition);
        cursor = documents.iterator();
        while (cursor.hasNext()) {
            Document doc = cursor.next();
            Double codzona = doc.getDouble("codzona");
            Double codespecie = doc.getDouble("codespecie");
            Double extensiondanada = doc.getDouble("extensiondanada");
            Double exemplaresmetro = doc.getDouble("exemplaresmetro");
            System.out.println(" codigoZona: " + codzona + " codigoEspecie: "
                    + codespecie + " extensionDanada: " + extensiondanada + " exemplaresMetro: " + exemplaresmetro);
        }
    }

    public Double calcularDano(String campo, Object valor) {
        condition = new BasicDBObject(campo, valor);
        documents = coleccion.find(condition);
        cursor = documents.iterator();
        Double totalDano = 0.0;
        while (cursor.hasNext()) {
            Document doc = cursor.next();
            Double Dano = doc.getDouble("extensiondanada");
            totalDano += Dano;
        }
        return totalDano;
    }

    public Double calcularGastoExemplares(String campo, Object valor) {
        condition = new BasicDBObject(campo, valor);
        documents = coleccion.find(condition);
        cursor = documents.iterator();
        Double total = 0.0;
        Double parcial = 0.0;
        while (cursor.hasNext()) {
            Document doc = cursor.next();
            Double extension = doc.getDouble("extensiondanada");
            Double exemplarmetro = doc.getDouble("exemplaresmetro");
            total += extension * exemplarmetro;
        }
        return total;
    }
    // Postgres
    public void insertarDatosPost(Double codz, String nomz, Double totaldano, Double totalExemplares) throws SQLException {
        Conexion conn = new Conexion();
        Statement st = conn.conexion().createStatement();
        String update = "insert into resumo values(" + codz + ",'" + nomz + "',(" + totaldano + "," + totalExemplares + "));";
        st.executeUpdate(update);
        st.close();
    }
}

