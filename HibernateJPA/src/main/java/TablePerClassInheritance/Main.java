/*
package TablePerClassInheritance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("inheritance1");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Confectioner confectioner = new Confectioner();
        confectioner.setConfectionSpeciality("Cakes");
        confectioner.setKitchenDesignated(1);
        confectioner.setName("Walfelda");

        Waitress waitress = new Waitress();
        waitress.setPastryZone("Esplanade");
        waitress.setName("Mekie");

        Waitress waitress1 = new Waitress();
        waitress1.setPastryZone("Main room");
        waitress1.setName("Álvaro");

        entityManager.getTransaction().begin();
        entityManager.persist(confectioner);
        entityManager.persist(waitress);
        entityManager.persist(waitress1);
        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
*/
