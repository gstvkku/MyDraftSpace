package TablePerClassInheritance;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "waitress_table_per_class")
public class Waitress extends Employee {
    public String pastryZone;

    public String getPastryZone() {
        return pastryZone;
    }

    public void setPastryZone(String pastryZone) {
        this.pastryZone = pastryZone;
    }

}
