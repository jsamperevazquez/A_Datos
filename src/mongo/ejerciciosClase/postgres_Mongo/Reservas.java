package mongo.ejerciciosClase.postgres_Mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import mongo.ConexionMongo;
import ejerciciosClase.baserelacionalA.Conexion;

import mongo.MetodosMongo;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Reservas extends ConexionMongo implements MetodosMongo {
    Conexion conn = new Conexion();
    private static ObjectId id;
    private static String dni;
    private static double idVooIda,idVooVolta,prezoReserva,confirmado;
    public Reservas() throws SQLException {
    }

    public void reservaAvion(String _id
            , String dni
            , double idVooIda
            , double idVooVolta
            , double prezoReserva
            , double confirmado
    ) throws SQLException {
        Document document = new Document("dni",dni);
        document.append("idvooida",idVooIda);
        document.append("idvoovolta",idVooVolta);
        document.append("prezoreserva",prezoReserva);
        document.append("confirmado",confirmado);

        this.insertarEnDocu(document);
        PreparedStatement actualizar = conn.conexion().prepareStatement("update pasaxeiros set nreservas = nreservas +1 where dni= ?");
        actualizar.setString(1,dni);
        actualizar.execute();
    }
    public void confirmar(ObjectId objI) throws SQLException {
        BasicDBObject campo = new BasicDBObject("_id",objI);
        BasicDBObject set = new BasicDBObject("$set",new BasicDBObject("confirmado",1.0));
        updateDocu(campo,set);
        Statement consulta = conn.conexion().createStatement();
        consultarPorId(objI);
        ResultSet r = consulta.executeQuery("select sum(prezo) from voos where  voo='" + (int)idVooIda + "' or voo='" + (int)idVooVolta + "'");
        while (r.next()) {
            Double prezo = (double) r.getInt(1);
            actualizarPorID(id,"prezovoo",prezo);
        }
    }

    @Override
    public void consultarPorId(ObjectId objectid) {
        BasicDBObject condition = new BasicDBObject("_id",objectid);
        BasicDBObject campos = new BasicDBObject();
        campos.put("idvooida",1);
        campos.put("idvoovolta",1);
        Document document = coleccion.find(condition).projection(campos).first();
        id = document.getObjectId("_id");
        idVooIda = document.getDouble("idvooida");
        idVooVolta = document.getDouble("idvoovolta");
    }


    @Override
    public void consultarCampoValor(String campo, Object valor) {
        BasicDBObject condition = new BasicDBObject(campo,valor);
        FindIterable<Document> docs = coleccion.find(condition);
        MongoCursor<Document> cursor = docs.iterator();
        while (cursor.hasNext()){
            Document doc = cursor.next();
            id = doc.getObjectId("_id");
            dni = doc.getString("dni");
            idVooIda = doc.getDouble("idvoida");
            idVooVolta = doc.getDouble("idvoovolta");
        }
    }

    @Override
    public void actualizarPorID(ObjectId id, String campo, Object valor) {
        coleccion.updateOne(new BasicDBObject("_id",id),new BasicDBObject("$set",new BasicDBObject(campo,valor)));
    }

}
