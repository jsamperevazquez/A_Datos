package poracleneomongo;

import mongo.ConexionMongo;
import mongo.MetodosMongo;
import ejerciciosClase.baserelacionalA.Conexion;
import org.bson.Document;

import javax.persistence.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Aplicacion extends ConexionMongo implements MetodosMongo {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/composta.odb");
    EntityManager em = emf.createEntityManager();
    List<Composicion> listaComposicion;
    List<Componente> listaComponente;
    Document documento = new Document();

    public void tratarDatos() throws SQLException {
        int grasaTotal = 0;
        int grasaParcial = 0;
        Conexion conn = new Conexion();
        Statement st = conn.conexion().createStatement();
        ResultSet rs = st.executeQuery("Select codprato, (tipo).nomeprato,(tipo).prezo from prato;");
        while (rs.next()){
            System.out.println("Código plato: " + rs.getString(1) + ",nombre plato: " + rs.getString(2) + ",precio: " + rs.getInt(3));
            Query cw = em.createQuery("select c from Composicion c where c.codp='" + rs.getString(1) + "'", Composicion.class);
            listaComposicion = cw.getResultList();
            for (Composicion c:listaComposicion
            ) {
                documento.append("_id",c.getCodp());
                documento.append("nome",rs.getString(2));
                System.out.println(c.toString());
                Query cw2 = em.createQuery("select comp from Componente comp where comp.codc='" + c.getCodc() + "'",Componente.class);
                listaComponente = cw2.getResultList();
                for (Componente compo: listaComponente
                     ) {
                    grasaParcial = compo.graxa * c.getPeso() / 100;
                    System.out.println("Total parcial de grasa= " + grasaParcial);
                }
                grasaTotal += grasaParcial;
                documento.append("graxatotal",(double)grasaTotal);
                documento.append("prezo",(double)rs.getInt(3));
            }
            System.out.println("La grasa total del plato es: " + grasaTotal);
            insertarEnDocu(documento);
            grasaTotal = 0;
        }
    }
}
