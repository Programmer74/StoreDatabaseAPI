package usertypes;


import java.math.BigDecimal;

public class Address implements java.io.Serializable{
    private /*Integer*/ BigDecimal apartement;
    private /*Integer*/ BigDecimal building;
    private String street;
    private String city;
    private String ZipCode;

    public Address() { }

    public Address(/*Integer*/ BigDecimal appartement, /*Integer */ BigDecimal building, String street, String city, String ZipCode){
        this.apartement = appartement;
        this.building = building;
        this.street = street;
        this.city = city;
        this.ZipCode = ZipCode;
    }


    public /*Integer */ BigDecimal getAppartement() {
        return apartement;
    }

    public void setAppartement(/*Integer */ BigDecimal appartement) {
        this.apartement = appartement;
    }

    public /*Integer*/ BigDecimal getBuilding() {
        return building;
    }

    public void setBuilding(/*Integer*/ BigDecimal building) {
        this.building = building;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return ZipCode;
    }

    public void setZipCode(String zipCode) {
        ZipCode = zipCode;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;

        Address address = (Address) o;

        if (apartement != null ? !apartement.equals(address.apartement) : address.apartement != null) return false;
        if (building != null ? !building.equals(address.building) : address.building != null) return false;
        if (street != null ? !street.equals(address.street) : address.street != null) return false;
        if (city != null ? !city.equals(address.city) : address.city != null) return false;
        return ZipCode != null ? ZipCode.equals(address.ZipCode) : address.ZipCode == null;
    }

    @Override
    public int hashCode() {
        int result = apartement != null ? apartement.hashCode() : 0;
        result = 31 * result + (building != null ? building.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (ZipCode != null ? ZipCode.hashCode() : 0);
        return result;
    }

    @Override
    public String toString(){
        return ("{" + apartement + " " + building + " " + street + ", " + city + "}");
    }
}
