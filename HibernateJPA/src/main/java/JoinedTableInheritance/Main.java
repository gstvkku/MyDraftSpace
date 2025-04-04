package JoinedTableInheritance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("inheritance1");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Chef chef = new Chef();
        chef.setName("Jorge");
        chef.setSpeciality("Meet");

        Restaurant restaurant = new Restaurant();
        restaurant.setChef(chef);

        Pastry pastry = new Pastry();
        pastry.setConfectioner("Wafelda");

        entityManager.getTransaction().begin();
        entityManager.persist(restaurant);
        entityManager.persist(pastry);
        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
