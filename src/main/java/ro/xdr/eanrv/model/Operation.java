package ro.xdr.eanrv.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "operations")
public class Operation implements Serializable, EntityWithId<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "operationId", nullable = false)
    private Long id = 0l;

    @Column(name = "operationName", nullable = false)
    private String operationName;

    public Operation() {
    }

    public Operation(String operationName) {
        this.operationName = operationName;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", operationName='" + operationName + '\'' +
                '}';
    }
}
