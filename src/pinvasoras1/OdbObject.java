package pinvasoras1;

import ejerciciosClase.baserelacionalA.Conexion;

import java.sql.SQLException;
import java.util.List;

public class OdbObject {
    public static void main(String[] args) throws SQLException {
        Metodos metodos = new Metodos();
        //Conexión a servidor y base mongo
        metodos.conectar_servidor();
        metodos.conectar_base("test");
        metodos.apuntar_coleccion("encontradas");

        //Muestro todas las zonas de base OBJECTDB porque el método devuelve lista
        for (Zonas z : metodos.mostrarDatosTabla()
        ) {
            System.out.println("Consulta de BD ODB");
            System.out.println("Código zona: " + z.getCodz() + " Nombre zona: " + z.getNomz() + " Superficie: " + z.getSuperficie() + "\n");
            System.out.println("Consulta BD MONGO");
            // Devuelvo cada Documento de la colección "encontradas"
            metodos.consultarCampoValor("codzona", (double) z.getCodz());

            // Calculamos daño de cada código zona
            System.out.println("La suma total de dano para la zona es: " + metodos.calcularDano("codzona", (double) z.getCodz()));

            // Calculamos el gasto de ejemplares
            System.out.println("Total de ejemplares en la zona:  " + metodos.calcularGastoExemplares("codzona",(double) z.getCodz()));
            System.out.println("\n");

            // Insertamos datos en tabla resumo
            metodos.insertarDatosPost((double)z.getCodz(),z.getNomz(), metodos.calcularDano("codzona", (double) z.getCodz()), metodos.calcularGastoExemplares("codzona", (double) z.getCodz()));
        }
        metodos.cerrarConexion();
    }
}

