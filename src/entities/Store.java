package entities;

import org.hibernate.annotations.Columns;
import usertypes.Address;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import usertypes.AddressUserType;

@Entity(name = "Store")
@Table(name="STORE")
public class Store {
    @Id @Column(name="store_id")
    private Integer storeId;

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public AddressUserType getAddress() {
        return address;
    }

    public void setAddress(AddressUserType address) {
        this.address = address;
    }

    @org.hibernate.annotations.Type(type = "usertypes.AddressUserType")
    //@Column(name = "store_address")
    @Columns(columns = { @Column(name = "appartement"),
        @Column(name="building"), @Column(name="street"), @Column(name = "city"),
        @Column(name="ZipCode")})
    private AddressUserType address;

    public Store() { }

    public Store(Integer id, AddressUserType address){
        this.storeId = id;
        this.address = address;
    }


}
