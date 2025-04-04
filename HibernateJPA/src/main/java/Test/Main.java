/*
package Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Address address = new Address();
        address.setCity("Fortaleza");
        address.setStreet("Beira-Mar");
        address.setZipcode("8987");

        Customer customer = new Customer();
        customer.setName("Wafelda");
        customer.setAddress(address);

        entityManager.getTransaction().begin();
        entityManager.persist(customer);
        entityManager.getTransaction().commit();
        Customer savedCustomer = entityManager.find(Customer.class, customer);
        entityManager.close();

        System.out.println(savedCustomer);

    }
}
*/
