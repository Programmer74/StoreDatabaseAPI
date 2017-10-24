package entities;

import javax.persistence.*;

@Entity
@Table(name="CLIENTS")
public class Clients implements java.io.Serializable{
    @Id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id"/*, referencedColumnName = "people_id"*/)
    private People clientId;

    public Clients() { }

    public Clients(People id){
        this.clientId = id;
    }

    public People getClientId() {
        return clientId;
    }

    public void setClientId(People clientId) {
        this.clientId = clientId;
    }

    public String toString(){
        return (clientId.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Clients)) return false;

        Clients clients = (Clients) o;

        return clientId.equals(clients.clientId);
    }

    @Override
    public int hashCode() {
        return clientId.hashCode();
    }
}