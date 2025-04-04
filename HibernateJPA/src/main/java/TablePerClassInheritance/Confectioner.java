package TablePerClassInheritance;

import TablePerClassInheritance.Employee;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "confectioner_table_per_class")
public class Confectioner extends Employee {
    public String confectionSpeciality;
    public int kitchenDesignated;

    public String getConfectionSpeciality() {
        return confectionSpeciality;
    }

    public void setConfectionSpeciality(String confectionSpeciality) {
        this.confectionSpeciality = confectionSpeciality;
    }

    public int getKitchenDesignated() {
        return kitchenDesignated;
    }

    public void setKitchenDesignated(int kitchenDesignated) {
        this.kitchenDesignated = kitchenDesignated;
    }
}


