package io.codeforall.bootcamp;

import javax.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {

        // FIRST EXERCISE
        EntityHandler entityHandler = new EntityHandler();

        Owner owner = new Owner();
        Car car = new Car();

        owner.setName("Mekie");
        car.setMake(":)");
        car.setModel("Álvaro");
        owner.setCar(car);
        car.setOwner(owner);

        entityHandler.saveOrUpdate(owner);

        // SECOND EXERCISE
        Product product = new Product();
        Category category = new Category();

        product.setName("Mouse");
        category.setName("Tech");
        category.addProduct(product);

        entityHandler.saveOrUpdate(product);
        entityHandler.saveOrUpdate(category);

    }
}
