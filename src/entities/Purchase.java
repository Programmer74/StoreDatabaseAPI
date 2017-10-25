package entities;

import javax.persistence.*;
import java.io.Serializable;

public class Purchase implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "purch_gen")
    @SequenceGenerator(name = "purch_gen", sequenceName = "purchase_seq")
    @Column(name = "puch_id", nullable = false, unique = true)
    private Integer purchId;
}
