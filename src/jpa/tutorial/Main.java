package jpa.tutorial;

import javax.persistence.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Open a database connection
        // (create a new database if it doesn't exist yet):
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("$objectdb/db/p2.odb");
        EntityManager em = emf.createEntityManager();

        //Creo otro entity Manager porque para hacer updates y mostrarlos necesito otro
        EntityManager em2 = emf.createEntityManager();

        // Creo 10 instancias de Point
        // Store 10 Point objects in the database:

        em.getTransaction().begin();
        for (int i = 0; i < 10; i++) {
            Point p = new Point(i, i);
            em.persist(p);
        }
        em.getTransaction().commit();


        // Muestra cantidad de objetos instanciado en Point
        // Find the number of Point objects in the database:
        Query q1 = em.createQuery("SELECT COUNT(p) FROM Point p");
        System.out.println("Total Points: " + q1.getSingleResult());

        // Find the average X value:
        // Promedio de puntos x
        Query q2 = em.createQuery("SELECT AVG(p.x) FROM Point p");
        System.out.println("Average X: " + q2.getSingleResult());

        // Retrieve all the Point objects from the database:
        // Muestra todos las instancias y campos de estos de Point (toString modificado)
        TypedQuery<Point> query =
                em.createQuery("SELECT p FROM Point p", Point.class);
        List<Point> results = query.getResultList();
        for (Point p : results) {
            System.out.println(p);
        }

        // Muestro el Objeto cuya id es 10
        TypedQuery<Point> query2 =
                em.createQuery("SELECT p FROM Point p where p.id = 10", Point.class );
        Point re = query2.getSingleResult();
        System.out.println("El punto " + re);

        //Actualizo el campo y sumando 2 al mismo a id 10
        em2.getTransaction().begin();
        Query query3 =
                em2.createQuery("UPDATE Point set y = y+2 where id = 10", Point.class );
        query3.executeUpdate();
        em2.getTransaction().commit();
        System.out.println(re);

        // Borro Punto id 5
        em2.getTransaction().begin();
        Query query4 =
                em2.createQuery("DELETE from Point p where p.id = 5", Point.class );
        query4.executeUpdate();
        em2.getTransaction().commit();

        // Actualización masiva de datos con clausula pasada por parámetro
        em2.getTransaction().begin();
        Query query5 = em2.createQuery("UPDATE Point set y = 1000" + " where y < :valor" , Point.class);
        query5.setParameter("valor", 6).executeUpdate(); // le pasamos la clausula
        em2.getTransaction().commit();
        // Borrador masivo de datos con clausula
        em2.getTransaction().begin();
        Query query6 = em2.createQuery("DELETE from Point p" + " where y < :valor" , Point.class);
        query6.setParameter("valor", 9).executeUpdate(); // le pasamos la clausula
        em2.getTransaction().commit();

        TypedQuery<Point> query7 =
                em2.createQuery("SELECT p FROM Point p", Point.class);
        List<Point> results2 = query7.getResultList();
        for (Point p : results2) {
            System.out.println(p);
        }


        // Close the database connection:
        em.close();
        em2.close();
        emf.close();
    }
}
