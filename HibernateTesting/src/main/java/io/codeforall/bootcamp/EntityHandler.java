package io.codeforall.bootcamp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityHandler {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");

    public Object saveOrUpdate(Object object) {

        System.out.println("Begin of method");

         EntityManager entityManager = emf.createEntityManager();

        try {

            entityManager.getTransaction().begin(); // open transaction

            System.out.println("After begin transaction");
            Object newObject = entityManager.merge(object);
            System.out.println("After merge");
            entityManager.getTransaction().commit(); // close transaction
            System.out.println("After commit");
            return newObject;

        } catch (Exception e) {

            entityManager.getTransaction().rollback();

        } finally {
            if (entityManager != null) {
                entityManager.close();
            }

        }

        return null;
    }

    public Object findById(Object id) {

        EntityManager entityManager = emf.createEntityManager();

        try {
            // fetch a new user using its id
            return entityManager.find(Object.class, id); // always the primary key
        } finally {
            // make sure we close the database connection
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

}
