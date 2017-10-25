package entities;

import javax.persistence.*;

@Entity
@Table(name="CLIENTS")
public class Client implements java.io.Serializable{
    @Id
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "client_id", referencedColumnName = "people_id",
                nullable = false, unique = true)
    private People clientId;

    public Client() { }

    public Client(People id){
        this.clientId = id;
    }

    public People getClientId() {
        return clientId;
    }

    public void setClientId(People clientId) {
        this.clientId = clientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;

        Client client = (Client) o;

        return clientId.equals(client.clientId);
    }

    @Override
    public int hashCode() {
        return clientId.hashCode();
    }
}