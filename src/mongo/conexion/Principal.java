package mongo.conexion;


import com.mongodb.BasicDBObject;
import mongo.conexion.MongoConexion;
import org.bson.Document;

public class Principal {
    public static void main(String[] args) {
        Document document = new Document("kind","taller")
                .append("score", 61.0)
                .append("enderezo", new Document()
                        .append("rua","urzaiz")
                        .append("numero", 4)
                        .append("cidade", "vigo")
                );
        BasicDBObject campo = new BasicDBObject("kind","taller");
        BasicDBObject set = new BasicDBObject("$set",new BasicDBObject("score",98.0));
        BasicDBObject borrar = new BasicDBObject("kind", "taller");
        MongoConexion mongo = new MongoConexion();
        mongo.conectar_servidor();
        mongo.conectar_base("training");
        mongo.apuntar_coleccion("scores");
        //mongo.insertarEnDocu(document);
        //mongo.updateDocu(campo,set);
        mongo.deleteDocu(borrar);
        mongo.conectar_servidor().close();


    }
}
