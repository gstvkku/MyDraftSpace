import javax.persistence.*;

@Entity
    @Table(name = "customers")
    public class Customers {
        @Id
        private Integer id;
        private String name;
        @Embedded
        private Address address;
    }

