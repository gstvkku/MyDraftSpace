package JoinedTableInheritance;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "PastryJoinedTable")
@Table(name = "pastry_joined_table")
public class Pastry extends Enterprise{
    private String confectioner;

    public String getConfectioner() {
        return confectioner;
    }

    public void setConfectioner(String confectioner) {
        this.confectioner = confectioner;
    }

}
