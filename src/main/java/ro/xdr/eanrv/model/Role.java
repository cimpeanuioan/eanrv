package ro.xdr.eanrv.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Entity
@Table(name = "roles")
public class Role implements Serializable, EntityWithId<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roleId", nullable = false)
    private Long id = 0l;

    @Column(name = "roleName", nullable = false)
    private String roleName;

    // uni-directional many-to-many association to Operation
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "operationsbyroles", joinColumns = { @JoinColumn(name = "roleId") },
            inverseJoinColumns = { @JoinColumn(name = "operationId") })
    private Set<Operation> operations;

    public Role() {
    }

    public Role(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<Operation> getOperations() {
        return operations;
    }

    public void setOperations(Set<Operation> operations) {
        this.operations = operations;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", operations=" + operations +
                '}';
    }
}
