package mongo;

import org.bson.types.ObjectId;

import java.sql.SQLException;

public interface MetodosMongo {
    // Método para listar documentos
    default void consultarPorId(ObjectId objectid){
        /*
        EJEMPLO1:

        BasicDBObject condition = new BasicDBObject("_id",objectid);
        // projection son los campos que quiero recuperar:
        Document document = coleccion.find(condition).projection(Projections.include("_id","kind","score")).first();
        //Recojo los valores
        ObjectId objId = document.getObjectId("_id");
        String kind = document.getString("kind");
        Double score = document.getDouble("score");
        System.out.println("id: " + objId + " kind: " + kind + " score: " + score);

        -------------------------------------------------------------------------------------------------------------

        EJEMPLO2:

        BasicDBObject condition = new BasicDBObject("_id",objectId);
        BasicDBObject campos = new BasicDBObject();
        campos.put("kind",1);
        campos.put("score",1);
        Document document = coleccion.find(condition).projection(campos).first();
        ObjectId objId = document.getObjectId("_id");
        String kind = document.getString("kind");
        Double score = document.getDouble("score");
        System.out.println("id: " + objId + " kind: " + kind + " score: " + score);

        */
    }
    default void consultarCampoValor(String campo,Object valor) throws SQLException {
        /*
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
    */
    }
    default void actualizarPorID(ObjectId id,String campo, Object valor){
        /*
        coleccion.updateOne(new BasicDBObject("_id",id),new BasicDBObject("$set",new BasicDBObject(campo,valor)));
        */
    }
    default void incrementarCamposNumericos(ObjectId id,String campo, Object valor){
        /*
        coleccion.updateOne(new BasicDBObject("_id",id),new BasicDBObject("$inc",new BasicDBObject(campo,valor)));
        */
    }
    default void actualizarPorCampo(String id,String campo, Object valor){
         /*
        coleccion.updateOne(new BasicDBObject("_id",id),new BasicDBObject("$set",new BasicDBObject(campo,valor)));
        */
    }
}
