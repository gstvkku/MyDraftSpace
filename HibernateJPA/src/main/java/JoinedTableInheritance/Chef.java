package JoinedTableInheritance;

import javax.persistence.Embeddable;

@Embeddable
public class Chef {
    private String name;
    private String speciality;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
