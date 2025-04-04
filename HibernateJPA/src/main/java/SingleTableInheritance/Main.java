/*
package SingleTableInheritance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("inheritance1");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Cake cake = new Cake();
        cake.setFlavour("Double Chocolate");
        cake.setSize("Large");
        cake.setValue(15.0);

        Croissant croissant = new Croissant();
        croissant.setType("Sweet");
        croissant.setValue(3.0);

        entityManager.getTransaction().begin();
        entityManager.persist(cake);
        entityManager.persist(croissant);
        entityManager.getTransaction().commit();

        System.out.println(entityManager.find(Cake.class, 1));
        System.out.println(entityManager.find(Croissant.class, 2));

        entityManager.close();

    }
}
*/
