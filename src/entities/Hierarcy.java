package entities;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name = "hierarcy")
public class Hierarcy implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hierarcy_gen")
    @SequenceGenerator(name = "hierarcy_gen", sequenceName = "hierarcy_seq", allocationSize = 1)
    @Column(name = "hierarcy_id")
    private Integer hierarcyId;

    @Column(name = "hierarcy_name", nullable = false, unique = true)
    private String hierarcyName;

    @Column(name = "rating", nullable = false, unique = true)
    private Integer rating;

    public Hierarcy(String hierarcyName, Integer rating) {
        this.hierarcyName = hierarcyName;
        this.rating = rating;
    }

    public Hierarcy() { }

    public Integer getHierarcyId() {
        return hierarcyId;
    }

    public String getHierarcyName() {
        return hierarcyName;
    }

    public void setHierarcyName(String hierarcyName) {
        this.hierarcyName = hierarcyName;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hierarcy)) return false;

        Hierarcy hierarcy = (Hierarcy) o;

        if (hierarcyId != null ? !hierarcyId.equals(hierarcy.hierarcyId) : hierarcy.hierarcyId != null) return false;
        if (hierarcyName != null ? !hierarcyName.equals(hierarcy.hierarcyName) : hierarcy.hierarcyName != null)
            return false;
        return rating != null ? rating.equals(hierarcy.rating) : hierarcy.rating == null;
    }

    @Override
    public int hashCode() {
        int result = hierarcyId != null ? hierarcyId.hashCode() : 0;
        result = 31 * result + (hierarcyName != null ? hierarcyName.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        return result;
    }
}
