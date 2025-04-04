package JoinedTableInheritance;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "RestaurantJoinedTable")
@Table(name = "restaurant_joined_table")
public class Restaurant extends Enterprise {
    @Embedded
    private Chef chef;

    public Chef getChef() {
        return chef;
    }

    public void setChef(Chef chef) {
        this.chef = chef;
    }

}
