package ro.xdr.eanrv.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by rares.urdea on 23.01.2015.
 */
@Entity
@Table(name = "activepropertylist")
public class ActiveProperty {
    private int eanHotelId;

    @Id
    @Column(name = "EANHotelID", nullable = false, insertable = true, updatable = true)
    public int getEanHotelId() {
        return eanHotelId;
    }

    public void setEanHotelId(int eanHotelId) {
        this.eanHotelId = eanHotelId;
    }

    private Integer sequenceNumber;

    @Basic
    @Column(name = "SequenceNumber", nullable = true, insertable = true, updatable = true)
    public Integer getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    private String name;

    @Basic
    @Column(name = "Name", nullable = true, insertable = true, updatable = true, length = 70)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String address1;

    @Basic
    @Column(name = "Address1", nullable = true, insertable = true, updatable = true, length = 50)
    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    private String address2;

    @Basic
    @Column(name = "Address2", nullable = true, insertable = true, updatable = true, length = 50)
    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    private String city;

    @Basic
    @Column(name = "City", nullable = true, insertable = true, updatable = true, length = 50)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    private String stateProvince;

    @Basic
    @Column(name = "StateProvince", nullable = true, insertable = true, updatable = true, length = 2)
    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    private String postalCode;

    @Basic
    @Column(name = "PostalCode", nullable = true, insertable = true, updatable = true, length = 15)
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    private String country;

    @Basic
    @Column(name = "Country", nullable = true, insertable = true, updatable = true, length = 2)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    private BigDecimal latitude;

    @Basic
    @Column(name = "Latitude", nullable = true, insertable = true, updatable = true, precision = 5)
    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    private BigDecimal longitude;

    @Basic
    @Column(name = "Longitude", nullable = true, insertable = true, updatable = true, precision = 5)
    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    private String airportCode;

    @Basic
    @Column(name = "AirportCode", nullable = true, insertable = true, updatable = true, length = 3)
    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    private Integer propertyCategory;

    @Basic
    @Column(name = "PropertyCategory", nullable = true, insertable = true, updatable = true)
    public Integer getPropertyCategory() {
        return propertyCategory;
    }

    public void setPropertyCategory(Integer propertyCategory) {
        this.propertyCategory = propertyCategory;
    }

    private String propertyCurrency;

    @Basic
    @Column(name = "PropertyCurrency", nullable = true, insertable = true, updatable = true, length = 3)
    public String getPropertyCurrency() {
        return propertyCurrency;
    }

    public void setPropertyCurrency(String propertyCurrency) {
        this.propertyCurrency = propertyCurrency;
    }

    private BigDecimal starRating;

    @Basic
    @Column(name = "StarRating", nullable = true, insertable = true, updatable = true, precision = 1)
    public BigDecimal getStarRating() {
        return starRating;
    }

    public void setStarRating(BigDecimal starRating) {
        this.starRating = starRating;
    }

    private Integer confidence;

    @Basic
    @Column(name = "Confidence", nullable = true, insertable = true, updatable = true)
    public Integer getConfidence() {
        return confidence;
    }

    public void setConfidence(Integer confidence) {
        this.confidence = confidence;
    }

    private String supplierType;

    @Basic
    @Column(name = "SupplierType", nullable = true, insertable = true, updatable = true, length = 3)
    public String getSupplierType() {
        return supplierType;
    }

    public void setSupplierType(String supplierType) {
        this.supplierType = supplierType;
    }

    private String location;

    @Basic
    @Column(name = "Location", nullable = true, insertable = true, updatable = true, length = 80)
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    private Integer chainCodeId;

    @Basic
    @Column(name = "ChainCodeID", nullable = true, insertable = true, updatable = true)
    public Integer getChainCodeId() {
        return chainCodeId;
    }

    public void setChainCodeId(Integer chainCodeId) {
        this.chainCodeId = chainCodeId;
    }

    private Integer regionId;

    @Basic
    @Column(name = "RegionID", nullable = true, insertable = true, updatable = true)
    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    private BigDecimal highRate;

    @Basic
    @Column(name = "HighRate", nullable = true, insertable = true, updatable = true, precision = 4)
    public BigDecimal getHighRate() {
        return highRate;
    }

    public void setHighRate(BigDecimal highRate) {
        this.highRate = highRate;
    }

    private BigDecimal lowRate;

    @Basic
    @Column(name = "LowRate", nullable = true, insertable = true, updatable = true, precision = 4)
    public BigDecimal getLowRate() {
        return lowRate;
    }

    public void setLowRate(BigDecimal lowRate) {
        this.lowRate = lowRate;
    }

    private String checkInTime;

    @Basic
    @Column(name = "CheckInTime", nullable = true, insertable = true, updatable = true, length = 10)
    public String getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime;
    }

    private String checkOutTime;

    @Basic
    @Column(name = "CheckOutTime", nullable = true, insertable = true, updatable = true, length = 10)
    public String getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(String checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    private Timestamp timeStamp;

    @Basic
    @Column(name = "TimeStamp", nullable = false, insertable = true, updatable = true)
    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActiveProperty that = (ActiveProperty) o;

        if (eanHotelId != that.eanHotelId) return false;
        if (address1 != null ? !address1.equals(that.address1) : that.address1 != null) return false;
        if (address2 != null ? !address2.equals(that.address2) : that.address2 != null) return false;
        if (airportCode != null ? !airportCode.equals(that.airportCode) : that.airportCode != null) return false;
        if (chainCodeId != null ? !chainCodeId.equals(that.chainCodeId) : that.chainCodeId != null) return false;
        if (checkInTime != null ? !checkInTime.equals(that.checkInTime) : that.checkInTime != null) return false;
        if (checkOutTime != null ? !checkOutTime.equals(that.checkOutTime) : that.checkOutTime != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (confidence != null ? !confidence.equals(that.confidence) : that.confidence != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (highRate != null ? !highRate.equals(that.highRate) : that.highRate != null) return false;
        if (latitude != null ? !latitude.equals(that.latitude) : that.latitude != null) return false;
        if (location != null ? !location.equals(that.location) : that.location != null) return false;
        if (longitude != null ? !longitude.equals(that.longitude) : that.longitude != null) return false;
        if (lowRate != null ? !lowRate.equals(that.lowRate) : that.lowRate != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (postalCode != null ? !postalCode.equals(that.postalCode) : that.postalCode != null) return false;
        if (propertyCategory != null ? !propertyCategory.equals(that.propertyCategory) : that.propertyCategory != null)
            return false;
        if (propertyCurrency != null ? !propertyCurrency.equals(that.propertyCurrency) : that.propertyCurrency != null)
            return false;
        if (regionId != null ? !regionId.equals(that.regionId) : that.regionId != null) return false;
        if (sequenceNumber != null ? !sequenceNumber.equals(that.sequenceNumber) : that.sequenceNumber != null)
            return false;
        if (starRating != null ? !starRating.equals(that.starRating) : that.starRating != null) return false;
        if (stateProvince != null ? !stateProvince.equals(that.stateProvince) : that.stateProvince != null)
            return false;
        if (supplierType != null ? !supplierType.equals(that.supplierType) : that.supplierType != null) return false;
        if (timeStamp != null ? !timeStamp.equals(that.timeStamp) : that.timeStamp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = eanHotelId;
        result = 31 * result + (sequenceNumber != null ? sequenceNumber.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address1 != null ? address1.hashCode() : 0);
        result = 31 * result + (address2 != null ? address2.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (stateProvince != null ? stateProvince.hashCode() : 0);
        result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (airportCode != null ? airportCode.hashCode() : 0);
        result = 31 * result + (propertyCategory != null ? propertyCategory.hashCode() : 0);
        result = 31 * result + (propertyCurrency != null ? propertyCurrency.hashCode() : 0);
        result = 31 * result + (starRating != null ? starRating.hashCode() : 0);
        result = 31 * result + (confidence != null ? confidence.hashCode() : 0);
        result = 31 * result + (supplierType != null ? supplierType.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (chainCodeId != null ? chainCodeId.hashCode() : 0);
        result = 31 * result + (regionId != null ? regionId.hashCode() : 0);
        result = 31 * result + (highRate != null ? highRate.hashCode() : 0);
        result = 31 * result + (lowRate != null ? lowRate.hashCode() : 0);
        result = 31 * result + (checkInTime != null ? checkInTime.hashCode() : 0);
        result = 31 * result + (checkOutTime != null ? checkOutTime.hashCode() : 0);
        result = 31 * result + (timeStamp != null ? timeStamp.hashCode() : 0);
        return result;
    }
}
