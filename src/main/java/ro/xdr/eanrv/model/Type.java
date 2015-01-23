package ro.xdr.eanrv.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by rares.urdea on 23.01.2015.
 */
@Entity
public class Type {
    private int typeId;
    private int callType;
    private String alias;
    private String description;
    private Collection<StoredRequest> storedrequestsByTypeId;
    private Collection<StoredResponse> storedresponsesByTypeId;

    @Id
    @Column(name = "type_id", nullable = false, insertable = true, updatable = true)
    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    @Basic
    @Column(name = "call_type", nullable = false, insertable = true, updatable = true)
    public int getCallType() {
        return callType;
    }

    public void setCallType(int callType) {
        this.callType = callType;
    }

    @Basic
    @Column(name = "alias", nullable = false, insertable = true, updatable = true, length = 24)
    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    @Basic
    @Column(name = "description", nullable = true, insertable = true, updatable = true, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Type type = (Type) o;

        if (callType != type.callType) return false;
        if (typeId != type.typeId) return false;
        if (alias != null ? !alias.equals(type.alias) : type.alias != null) return false;
        if (description != null ? !description.equals(type.description) : type.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = typeId;
        result = 31 * result + callType;
        result = 31 * result + (alias != null ? alias.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "typeByTypeId")
    public Collection<StoredRequest> getStoredrequestsByTypeId() {
        return storedrequestsByTypeId;
    }

    public void setStoredrequestsByTypeId(Collection<StoredRequest> storedrequestsByTypeId) {
        this.storedrequestsByTypeId = storedrequestsByTypeId;
    }

    @OneToMany(mappedBy = "typeByTypeId")
    public Collection<StoredResponse> getStoredresponsesByTypeId() {
        return storedresponsesByTypeId;
    }

    public void setStoredresponsesByTypeId(Collection<StoredResponse> storedresponsesByTypeId) {
        this.storedresponsesByTypeId = storedresponsesByTypeId;
    }
}
