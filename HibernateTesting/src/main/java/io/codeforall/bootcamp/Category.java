package io.codeforall.bootcamp;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToMany(
            cascade = {CascadeType.ALL},
            orphanRemoval = true,
            // use Category foreign key on Product table to establish
            // the many-to-one relationship instead of a join table
            mappedBy = "category"
    )
    private Set<Product> products = new HashSet<>();

    // utility method to update both sides of the association
    public void addProduct(Product product) {
        products.add(product);
        product.setCategory(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}