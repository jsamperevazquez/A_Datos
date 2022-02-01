package mongo.conexion;


import com.mongodb.BasicDBObject;
import mongo.conexion.MongoConexion;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal {
    public static void main(String[] args) {
        // Desactivar logs de mongo
        Logger logger = Logger.getLogger("org.mongodb.driver");
        logger.setLevel(Level.SEVERE);


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
        ObjectId id = new ObjectId("4c90f2543d937c033f424798");
        ObjectId id2 = new ObjectId("4c90f2543d937c033f424985");
        MongoConexion mongo = new MongoConexion();
        mongo.conectar_servidor();
        mongo.conectar_base("training");
        mongo.apuntar_coleccion("scores");
        //mongo.insertarEnDocu(document);
        //mongo.updateDocu(campo,set);
        //mongo.consultarPorId(id2);
        //mongo.otraManeraConsultaPorID(id2);
        //mongo.consultarCampoValor("student",99.0);
        //mongo.deleteDocu(borrar);
        //mongo.actualizarPorID(id2,"score",75.0);
        //mongo.incrementarCamposNumericos(id2,"score",5.0);
        mongo.conectar_servidor().close();


    }
}
