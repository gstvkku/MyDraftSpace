package SingleTableInheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "CroissantSingleTable")
@DiscriminatorValue("croissant")

public class Croissant extends Product {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
