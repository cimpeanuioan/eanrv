package ro.xdr.eanrv.model;

import javax.persistence.*;

/**
 * Created by rares.urdea on 23.01.2015.
 */
@Entity
public class StoredResponse {
    private int responseId;
    private int requestId;
    private int typeId;
    private int eanHotelId;
    private boolean global;
    private String filePath;
    private StoredRequest storedRequestByRequestId;
    private Type typeByTypeId;

    @Id
    @Column(name = "response_id", nullable = false, insertable = true, updatable = true)
    public int getResponseId() {
        return responseId;
    }

    public void setResponseId(int responseId) {
        this.responseId = responseId;
    }

    @Basic
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
    @Column(name = "EANHotelID", nullable = false, insertable = true, updatable = true)
    public int getEanHotelId() {
        return eanHotelId;
    }

    public void setEanHotelId(int eanHotelId) {
        this.eanHotelId = eanHotelId;
    }

    @Basic
    @Column(name = "global", nullable = false, insertable = true, updatable = true)
    public boolean isGlobal() {
        return global;
    }

    public void setGlobal(boolean global) {
        this.global = global;
    }

    @Basic
    @Column(name = "file_path", nullable = false, insertable = true, updatable = true, length = 35)
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StoredResponse that = (StoredResponse) o;

        if (eanHotelId != that.eanHotelId) return false;
        if (global != that.global) return false;
        if (requestId != that.requestId) return false;
        if (responseId != that.responseId) return false;
        if (typeId != that.typeId) return false;
        if (filePath != null ? !filePath.equals(that.filePath) : that.filePath != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = responseId;
        result = 31 * result + requestId;
        result = 31 * result + typeId;
        result = 31 * result + eanHotelId;
        result = 31 * result + (global ? 1 : 0);
        result = 31 * result + (filePath != null ? filePath.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "request_id", referencedColumnName = "request_id", nullable = false)
    public StoredRequest getStoredRequestByRequestId() {
        return storedRequestByRequestId;
    }

    public void setStoredRequestByRequestId(StoredRequest storedRequestByRequestId) {
        this.storedRequestByRequestId = storedRequestByRequestId;
    }

    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "type_id", nullable = false)
    public Type getTypeByTypeId() {
        return typeByTypeId;
    }

    public void setTypeByTypeId(Type typeByTypeId) {
        this.typeByTypeId = typeByTypeId;
    }
}
