package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

public class Promotion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prom_seq")
    @SequenceGenerator(name = "prom_seq", sequenceName = "promotions_seq", allocationSize = 1)
    @Column(name = "promotion_id", nullable = false, unique = true)
    private Integer promotionId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "staff_id", referencedColumnName = "staff_id", nullable = false)
    private Staff staffId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "staff_positions", referencedColumnName = "hierarcy_id",
                nullable = false)
    private Integer staffPosition;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_promoted", nullable = false)
    private Date datePromoted;

    public Promotion() { }

    public Promotion(Staff staffId, Integer staffPosition, Date datePromoted) {
        this.staffId = staffId;
        this.staffPosition = staffPosition;
        this.datePromoted = datePromoted;
    }

    public Integer getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(Integer promotionId) {
        this.promotionId = promotionId;
    }

    public Staff getStaffId() {
        return staffId;
    }

    public void setStaffId(Staff staffId) {
        this.staffId = staffId;
    }

    public Integer getStaffPosition() {
        return staffPosition;
    }

    public void setStaffPosition(Integer staffPosition) {
        this.staffPosition = staffPosition;
    }

    public Date getDatePromoted() {
        return datePromoted;
    }

    public void setDatePromoted(Date datePromoted) {
        this.datePromoted = datePromoted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Promotion)) return false;

        Promotion promotion = (Promotion) o;

        if (!promotionId.equals(promotion.promotionId)) return false;
        if (!staffId.equals(promotion.staffId)) return false;
        if (!staffPosition.equals(promotion.staffPosition)) return false;
        return datePromoted.equals(promotion.datePromoted);
    }

    @Override
    public int hashCode() {
        int result = promotionId.hashCode();
        result = 31 * result + staffId.hashCode();
        result = 31 * result + staffPosition.hashCode();
        result = 31 * result + datePromoted.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Promotion{" +
                "promotionId=" + promotionId +
                ", staffId=" + staffId +
                ", staffPosition=" + staffPosition +
                ", datePromoted=" + datePromoted +
                '}';
    }
}
