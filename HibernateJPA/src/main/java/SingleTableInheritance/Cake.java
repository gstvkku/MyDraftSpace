package SingleTableInheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity(name = "CakeSingleTable")
@DiscriminatorValue("cake")

public class Cake extends Product {
    private String flavour;
    private String size;

    public String getFlavour() {
        return flavour;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
