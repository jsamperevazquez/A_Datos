package mongo.conexion;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.Map;

public class MongoConexion {
    public static MongoClient client;
    public static MongoDatabase database;
    public static MongoCollection<Document>coleccion;
    private Document documento;
    private final static String DIRECCION = "localhost";
    private final static int PUERTO = 27017;

    // Método para conectarse a servidor mongo
    public  MongoClient conectar_servidor(){
       client = new MongoClient(DIRECCION, PUERTO);
       return client;
    }
    //Método para conectarme a la base
    public  void conectar_base(String mongoBase){
        database = client.getDatabase(mongoBase);
    }
    //Método para apuntar a colección
    public void apuntar_coleccion(String colec){
        coleccion = database.getCollection(colec);
    }
    //Método para insertar valores en una Colección
    public void insertarEnDocu(Document documento) {
    coleccion.insertOne(documento);
    }
    //Metodo para hacer update en un documento
    public void updateDocu(BasicDBObject campo, BasicDBObject nuevos){
        coleccion.updateOne(campo,nuevos);
    }
    //Metodo para borrar un documento de una colección
    public void deleteDocu(BasicDBObject campo){
        coleccion.deleteOne(campo);
    }
    //Método para listar documentos
    public void consultarPorId(ObjectId objectid){
        BasicDBObject condition = new BasicDBObject("_id",objectid);
        Document document = coleccion.find(condition).projection(Projections.include("_id","kind","score")).first();

    }
}
