package JoinedTableInheritance;

import javax.persistence.*;

@Entity(name = "EnterpriseJoinedTable")
@Table(name = "enterprise_joined_table")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Enterprise {
    @Id
    private Integer id;
}