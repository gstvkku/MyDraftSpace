package TablePerClassInheritance;
import javax.persistence.*;

@Entity(name = "EmployeeTable")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
