package ro.xdr.eanrv.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by rares.urdea on 23.01.2015.
 */
@Entity
public class StoredRequest {
    private int requestId;
    private int typeId;
    private int userId;
    private String filePath;
    private Timestamp creationDate;
    private String description;
    private Type typeByTypeId;
    private Collection<StoredResponse> storedresponsesByRequestId;

    @Id
    @Column(name = "request_id", nullable = false, insertable = true, updatable = true)
    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    @Basic
    @Column(name = "type_id", nullable = false, insertable = true, updatable = true)
    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    @Basic
    @Column(name = "user_id", nullable = false, insertable = true, updatable = true)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "file_path", nullable = false, insertable = true, updatable = true, length = 35)
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Basic
    @Column(name = "creation_date", nullable = false, insertable = true, updatable = true)
    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
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

        StoredRequest that = (StoredRequest) o;

        if (requestId != that.requestId) return false;
        if (typeId != that.typeId) return false;
        if (userId != that.userId) return false;
        if (creationDate != null ? !creationDate.equals(that.creationDate) : that.creationDate != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (filePath != null ? !filePath.equals(that.filePath) : that.filePath != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = requestId;
        result = 31 * result + typeId;
        result = 31 * result + userId;
        result = 31 * result + (filePath != null ? filePath.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "type_id", nullable = false)
    public Type getTypeByTypeId() {
        return typeByTypeId;
    }

    public void setTypeByTypeId(Type typeByTypeId) {
        this.typeByTypeId = typeByTypeId;
    }

    @OneToMany(mappedBy = "storedRequestByRequestId")
    public Collection<StoredResponse> getStoredresponsesByRequestId() {
        return storedresponsesByRequestId;
    }

    public void setStoredresponsesByRequestId(Collection<StoredResponse> storedresponsesByRequestId) {
        this.storedresponsesByRequestId = storedresponsesByRequestId;
    }
}
