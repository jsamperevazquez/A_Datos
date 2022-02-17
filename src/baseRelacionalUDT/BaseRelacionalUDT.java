package baseRelacionalUDT;
import ejerciciosClase.baserelacionalA.Conexion;
import org.postgresql.util.PGobject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseRelacionalUDT {
    public static void main(String[] args) throws SQLException {
        Conexion conn = new Conexion();
        Statement st = conn.conexion().createStatement();
        // Inserccion:
        //String inserccion = "insert into produtost values('p2','escoba',15,null,('lugo',4))";
        //String actualizar = "update produtost set ci.cidade = 'barna' where codigo = 'p1'";
        String actualizar = "update produtost set ci.cp=(ci).cp+1 where(ci).cidade='barna'"; // Importante el paréntesis del lado derecho
        st.executeUpdate(actualizar);
        String consulta = "Select * from produtost";
        ResultSet rt = st.executeQuery(consulta);
        while (rt.next()){
            PGobject po = (PGobject)rt.getObject(5);
            String[] valores;
            valores = po.getValue().split(",");
            System.out.println(rt.getString(1) + " " + rt.getString(2) + " " +
                    rt.getDouble(3) + " " + valores[0].substring(1));
        }
    }
}
