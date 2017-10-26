package entities;

import usertypes.Address;
import usertypes.Pname;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "PEOPLE_TAB")
public class People implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "people_gen")
    @SequenceGenerator(name="people_gen", sequenceName = "people_seq", allocationSize = 1)
    //@GeneratedValue(strategy = GenerationType.IDENTITY) // works
    @Column(name="people_id")
    private Integer peopleId;

    @Column(name="people_name", columnDefinition="PNAME_T")
    @org.hibernate.annotations.Type(type = "usertypes.PnameUserType")
    private Pname peopleName;

    @Column(name="email")
    private String email;

    @Column(name="sex")
    private String sex;

    @Column(name="p_address", columnDefinition="ADDRESS")
    @org.hibernate.annotations.Type(type = "usertypes.AddressUserType")
    private Address address;

    @Column(name = "phone")
    private BigDecimal phone;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_registered")
    private Date dateRegistered;

    @Column(name = "password")
    private String password;

    @Column(name = "id_number", unique = true)
    private BigDecimal idNumber;

    public People() { }

    public People(int peopleId, Address address, BigDecimal phone, Date dateOfBirth,
                  Date dateRegistered, String password, BigDecimal idNumber,
                  Pname peopleName){
        this.peopleId = peopleId;
        this.address = address;
        this.peopleName = peopleName;
        this.dateOfBirth = dateOfBirth;
        this.dateRegistered = dateRegistered;
        this.password = password;
        this.phone = phone;
        this.idNumber = idNumber;
    }

    public Integer getPeopleId() {
        return peopleId;
    }

     public void setPeopleId(Integer peopleId) {
        this.peopleId = peopleId;
    }

    public Pname getPeopleName() {
        return peopleName;
    }

    public void setPeopleName(Pname peopleName) {
        this.peopleName = peopleName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public BigDecimal getPhone() {
        return phone;
    }

    public void setPhone(BigDecimal phone) {
        this.phone = phone;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(BigDecimal idNumber) {
        this.idNumber = idNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof People)) return false;

        People people = (People) o;

        if (peopleId != people.peopleId) return false;
        if (idNumber != people.idNumber) return false;
        if (peopleName != null ? !peopleName.equals(people.peopleName) : people.peopleName != null) return false;
        if (email != null ? !email.equals(people.email) : people.email != null) return false;
        if (sex != null ? !sex.equals(people.sex) : people.sex != null) return false;
        if (address != null ? !address.equals(people.address) : people.address != null) return false;
        if (phone != null ? !phone.equals(people.phone) : people.phone != null) return false;
        if (dateOfBirth != null ? !dateOfBirth.equals(people.dateOfBirth) : people.dateOfBirth != null) return false;
        if (dateRegistered != null ? !dateRegistered.equals(people.dateRegistered) : people.dateRegistered != null)
            return false;
        return password != null ? password.equals(people.password) : people.password == null;
    }

    @Override
    public int hashCode() {
        int result = peopleId;
        result = 31 * result + (peopleName != null ? peopleName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + (dateRegistered != null ? dateRegistered.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        //result = 31 * result + idNumber;
        return result;
    }

    @Override
    public String toString() {
        return "People{" +
                "peopleId=" + peopleId +
                ", peopleName=" + peopleName +
                ", email='" + email + '\'' +
                ", sex='" + sex + '\'' +
                ", address=" + address +
                ", phone=" + phone +
                ", dateOfBirth=" + dateOfBirth +
                ", dateRegistered=" + dateRegistered +
                ", password='" + password + '\'' +
                ", idNumber=" + idNumber +
                '}';
    }
}