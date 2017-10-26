package entities;

import usertypes.Address;

import javax.persistence.*;


@Entity(name = "Store")
@Table(name="STORE")
public class Store implements java.io.Serializable {
    @Id @Column(name="store_id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "store_gen")
    @SequenceGenerator(name = "store_gen", sequenceName = "store_seq", allocationSize = 1)
    private Integer storeId;

    //@org.hibernate.annotations.Type(type = "usertypes.AddressUserType")
    //@Column(name = "store_address")
    /*@Columns(columns = { @Column(name = "appartement"),
        @Column(name="building"), @Column(name="street"), @Column(name = "city"),
        @Column(name="ZipCode")}) */
    @Column(name="store_address", columnDefinition="ADDRESS")
    @org.hibernate.annotations.Type(type = "usertypes.AddressUserType")
    private Address/*UserType*/ storeAddress;

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Address getStoreAddress() {
        return storeAddress;
    }

    public void setAddress(Address/*UserType*/ address) {
        this.storeAddress = address;
    }



    public Store() { }

    public Store(Integer id, Address/*UserType*/ address){
        this.storeId = id;
        this.storeAddress = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Store)) return false;

        Store store = (Store) o;

        if (!storeId.equals(store.storeId)) return false;
        return storeAddress.equals(store.storeAddress);
    }

    @Override
    public int hashCode() {
        int result = storeId.hashCode();
        result = 31 * result + storeAddress.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Store{" +
                "storeId=" + storeId +
                ", storeAddress=" + storeAddress +
                '}';
    }
}
