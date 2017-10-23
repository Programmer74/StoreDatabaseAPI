package entities;

import usertypes.Address;
import usertypes.Pname;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "PEOPLE_TAB")
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="people_id")
    /*@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="client_id", unique = true)*/
    private int peopleId;

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

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "date_of_registered")
    private Date dateRegistered;

    @Column(name = "password")
    private String password;

    @Column(name = "id_number", unique = true)
    private int idNumber;

    public People() { }

    public People(int peopleId, Address address, BigDecimal phone, Date dateOfBirth,
                  Date dateRegistered, String password, int idNumber,
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

    public int getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(int peopleId) {
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

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    @Override
    public String toString() {
        return (peopleId + ". " + peopleName.toString() + " " +
            email + " " + dateOfBirth.toString());
    }
}
