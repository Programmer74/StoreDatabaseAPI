package usertypes;


public class Address implements java.io.Serializable{
    private Integer appartement;
    private Integer building;
    private String street;
    private String city;
    private String ZipCode;

    public Address() { }

    public Address(Integer appartement, Integer building, String street, String city, String ZipCode){
        this.appartement = appartement;
        this.building = building;
        this.street = street;
        this.city = city;
        this.ZipCode = ZipCode;
    }


    public Integer getAppartement() {
        return appartement;
    }

    public void setAppartement(Integer appartement) {
        this.appartement = appartement;
    }

    public Integer getBuilding() {
        return building;
    }

    public void setBuilding(Integer building) {
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

        if (appartement != null ? !appartement.equals(address.appartement) : address.appartement != null) return false;
        if (building != null ? !building.equals(address.building) : address.building != null) return false;
        if (street != null ? !street.equals(address.street) : address.street != null) return false;
        if (city != null ? !city.equals(address.city) : address.city != null) return false;
        return ZipCode != null ? ZipCode.equals(address.ZipCode) : address.ZipCode == null;
    }

    @Override
    public int hashCode() {
        int result = appartement != null ? appartement.hashCode() : 0;
        result = 31 * result + (building != null ? building.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (ZipCode != null ? ZipCode.hashCode() : 0);
        return result;
    }
}
