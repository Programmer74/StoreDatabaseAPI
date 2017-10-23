package entities;

import javax.persistence.*;

@Entity
@Table(name="staff")
public class Staff implements java.io.Serializable{
    @Id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "staff_id"/*, referencedColumnName = "people_id"*/)
    private People staff;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    @OneToOne
    @JoinColumn(name="pic_id", nullable = true, unique = true)
    private Picture pic;

    public Staff() { }

    public Staff(People staff, Store store, Picture pic) {
        this.staff = staff;
        this.store = store;
        this.pic = pic;
    }

    public People getStaff() {
        return staff;
    }

    public void setStaff(People staff) {
        this.staff = staff;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Picture getPic() {
        return pic;
    }

    public void setPic(Picture pic) {
        this.pic = pic;
    }

    @Override
    public String toString(){
        return (staff.toString() + " " + store.getStoreId());
    }
}
