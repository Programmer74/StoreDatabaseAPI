package entities;

import org.hibernate.annotations.Columns;
import usertypes.Address;

import javax.persistence.*;

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

    public Address/*UserType*/ getAddress() {
        return address;
    }

    public void setAddress(Address/*UserType*/ address) {
        this.address = address;
    }

    //@org.hibernate.annotations.Type(type = "usertypes.AddressUserType")
    //@Column(name = "store_address")
    /*@Columns(columns = { @Column(name = "appartement"),
        @Column(name="building"), @Column(name="street"), @Column(name = "city"),
        @Column(name="ZipCode")}) */
    @Column(name="store_address", columnDefinition="ADDRESS")
    @org.hibernate.annotations.Type(type = "usertypes.AddressUserType")
    private Address/*UserType*/ address;

    public Store() { }

    public Store(Integer id, Address/*UserType*/ address){
        this.storeId = id;
        this.address = address;
    }


}
