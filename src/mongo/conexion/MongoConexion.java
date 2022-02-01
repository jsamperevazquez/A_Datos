package mongo.conexion;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
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
        // projection son los campos que quiero recuperar:
        Document document = coleccion.find(condition).projection(Projections.include("_id","kind","score")).first();
        //Recojo los valores
        ObjectId objId = document.getObjectId("_id");
        String kind = document.getString("kind");
        Double score = document.getDouble("score");
        System.out.println("id: " + objId + " kind: " + kind + " score: " + score);
    }
    public void otraManeraConsultaPorID(ObjectId objectId){
        BasicDBObject condition = new BasicDBObject("_id",objectId);
        BasicDBObject campos = new BasicDBObject();
        campos.put("kind",1);
        campos.put("score",1);
        Document document = coleccion.find(condition).projection(campos).first();
        ObjectId objId = document.getObjectId("_id");
        String kind = document.getString("kind");
        Double score = document.getDouble("score");
        System.out.println("id: " + objId + " kind: " + kind + " score: " + score);
    }

    public void consultarCampoValor(String campo,Object valor){
        BasicDBObject condition = new BasicDBObject(campo,valor);
        FindIterable<Document> docs = coleccion.find(condition);
        MongoCursor<Document> cursor = docs.iterator();
        while (cursor.hasNext()){
            Document doc = cursor.next();
            ObjectId objId = doc.getObjectId("_id");
            String kind = doc.getString("kind");
            Double score = doc.getDouble("score");
            Double student = doc.getDouble("student");
            System.out.println("id: " + objId + " kind: " + kind + " score: " + score + " student: " + student);
        }
    }
    public void actualizarPorID(ObjectId id,String campo, Object valor){
        coleccion.updateOne(new BasicDBObject("_id",id),new BasicDBObject("$set",new BasicDBObject(campo,valor)));
    }

    public void incrementarCamposNumericos(ObjectId id,String campo, Object valor){
        coleccion.updateOne(new BasicDBObject("_id",id),new BasicDBObject("$inc",new BasicDBObject(campo,valor)));
    }
}
