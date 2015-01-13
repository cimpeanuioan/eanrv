package ro.xdr.eanrv.model;

import javax.persistence.*;

/**
 * Created by ioan.cimpeanu on 12.01.2015.
 */
@Table(name = "comparison")
@Entity
public class Comparison {
    private int id;
    private String httpRqA;
    private String httpRqB;
    private String responseA;
    private String responseB;
    private Byte invalid;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "HttpRqA")
    public String getHttpRqA() {
        return httpRqA;
    }

    public void setHttpRqA(String httpRqA) {
        this.httpRqA = httpRqA;
    }

    @Basic
    @Column(name = "HttpRqB")
    public String getHttpRqB() {
        return httpRqB;
    }

    public void setHttpRqB(String httpRqB) {
        this.httpRqB = httpRqB;
    }

    @Basic
    @Column(name = "ResponseA")
    public String getResponseA() {
        return responseA;
    }

    public void setResponseA(String responseA) {
        this.responseA = responseA;
    }

    @Basic
    @Column(name = "ResponseB")
    public String getResponseB() {
        return responseB;
    }

    public void setResponseB(String responseB) {
        this.responseB = responseB;
    }

    @Basic
    @Column(name = "Invalid")
    public Byte getInvalid() {
        return invalid;
    }

    public void setInvalid(Byte invalid) {
        this.invalid = invalid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comparison that = (Comparison) o;

        if (id != that.id) return false;
        if (httpRqA != null ? !httpRqA.equals(that.httpRqA) : that.httpRqA != null) return false;
        if (httpRqB != null ? !httpRqB.equals(that.httpRqB) : that.httpRqB != null) return false;
        if (invalid != null ? !invalid.equals(that.invalid) : that.invalid != null) return false;
        if (responseA != null ? !responseA.equals(that.responseA) : that.responseA != null) return false;
        if (responseB != null ? !responseB.equals(that.responseB) : that.responseB != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (httpRqA != null ? httpRqA.hashCode() : 0);
        result = 31 * result + (httpRqB != null ? httpRqB.hashCode() : 0);
        result = 31 * result + (responseA != null ? responseA.hashCode() : 0);
        result = 31 * result + (responseB != null ? responseB.hashCode() : 0);
        result = 31 * result + (invalid != null ? invalid.hashCode() : 0);
        return result;
    }
}