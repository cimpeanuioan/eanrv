package ro.xdr.eanrv.model;

import javax.persistence.*;

/**
 * Created by ioan.cimpeanu on 12.01.2015.
 */
@Table(name = "difference")
@Entity
public class Difference {
    private int id;
    private int comparisonId;
    private String node;
    private String valueA;
    private String valueB;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "comparisonId")
    public int getComparisonId() {
        return comparisonId;
    }

    public void setComparisonId(int comparisonId) {
        this.comparisonId = comparisonId;
    }

    @Basic
    @Column(name = "Node")
    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    @Basic
    @Column(name = "ValueA")
    public String getValueA() {
        return valueA;
    }

    public void setValueA(String valueA) {
        this.valueA = valueA;
    }

    @Basic
    @Column(name = "ValueB")
    public String getValueB() {
        return valueB;
    }

    public void setValueB(String valueB) {
        this.valueB = valueB;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Difference that = (Difference) o;

        if (comparisonId != that.comparisonId) return false;
        if (id != that.id) return false;
        if (node != null ? !node.equals(that.node) : that.node != null) return false;
        if (valueA != null ? !valueA.equals(that.valueA) : that.valueA != null) return false;
        if (valueB != null ? !valueB.equals(that.valueB) : that.valueB != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + comparisonId;
        result = 31 * result + (node != null ? node.hashCode() : 0);
        result = 31 * result + (valueA != null ? valueA.hashCode() : 0);
        result = 31 * result + (valueB != null ? valueB.hashCode() : 0);
        return result;
    }
}
