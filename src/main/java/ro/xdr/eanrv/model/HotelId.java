package ro.xdr.eanrv.model;

import javax.persistence.*;

/**
 * Created by ioan.cimpeanu on 12.01.2015.
 */
@Table(name = "hotelid")
@Entity
public class HotelId {
    private int eanHotelId;
    private String name;
    private Boolean processed;

    public HotelId() {
    }

    public HotelId(int eanHotelId, String name, Boolean processed) {
        this.eanHotelId = eanHotelId;
        this.name = name;
        this.processed = processed;
    }

    @Id
    @Column(name = "EANHotelID")
    public int getEanHotelId() {
        return eanHotelId;
    }

    public void setEanHotelId(int eanHotelId) {
        this.eanHotelId = eanHotelId;
    }

    @Basic
    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Processed")
    public Boolean getProcessed() {
        return processed;
    }

    public void setProcessed(Boolean processed) {
        this.processed = processed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HotelId hotelId = (HotelId) o;

        if (eanHotelId != hotelId.eanHotelId) return false;
        if (!name.equals(hotelId.name)) return false;
        if (!processed.equals(hotelId.processed)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = eanHotelId;
        result = 31 * result + name.hashCode();
        result = 31 * result + processed.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "HotelId{" +
                "eanHotelId=" + eanHotelId +
                ", name='" + name + '\'' +
                ", processed=" + processed +
                '}';
    }
}
