package entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="CLIENTS")
public class Client implements java.io.Serializable{
    @Id
    @GeneratedValue(generator = "people_gen")
    @GenericGenerator(name = "people_gen", strategy = "foreign",
        parameters =  @org.hibernate.annotations.Parameter(name="property", value = "people"))
    @Column(name = "client_id", unique = true, nullable = false)
    private Integer clientId;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(referencedColumnName = "people_id")
    private People people;

    public Client() { }

    public Client(People id){
        this.people = id;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People clientId) {
        this.people = clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", people=" + people +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;

        Client client = (Client) o;

        if (!clientId.equals(client.clientId)) return false;
        return people.equals(client.people);
    }

    @Override
    public int hashCode() {
        int result = clientId.hashCode();
        result = 31 * result + people.hashCode();
        return result;
    }
}