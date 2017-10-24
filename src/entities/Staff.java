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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Staff)) return false;

        Staff staff1 = (Staff) o;

        if (staff != null ? !staff.equals(staff1.staff) : staff1.staff != null) return false;
        if (store != null ? !store.equals(staff1.store) : staff1.store != null) return false;
        return pic != null ? pic.equals(staff1.pic) : staff1.pic == null;
    }

    @Override
    public int hashCode() {
        int result = staff != null ? staff.hashCode() : 0;
        result = 31 * result + (store != null ? store.hashCode() : 0);
        result = 31 * result + (pic != null ? pic.hashCode() : 0);
        return result;
    }
}
