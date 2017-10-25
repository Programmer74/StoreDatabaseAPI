package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Clob;

public class Review implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rew_gen")
    @SequenceGenerator(name = "rew_gen", sequenceName = "review_seq")
    @Column(name = "review_id", nullable = false, unique = true)
    private Integer reviewId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "prod_id", referencedColumnName = "prod_id", nullable = false)
    private Integer prodId;

    @Column(name = "rating", nullable = false)
    private Integer rating;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", referencedColumnName = "client_id")
    private Integer clientId;

    @Column(name = "review_body")
    private Clob reviewBody;

    public Review() { }

    public Review(Integer prodId, Integer rating, Integer clientId, Clob reviewBody) {
        this.prodId = prodId;
        this.rating = rating;
        this.clientId = clientId;
        this.reviewBody = reviewBody;
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public Integer getProdId() {
        return prodId;
    }

    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Clob getReviewBody() {
        return reviewBody;
    }

    public void setReviewBody(Clob reviewBody) {
        this.reviewBody = reviewBody;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Review)) return false;

        Review review = (Review) o;

        if (reviewId != null ? !reviewId.equals(review.reviewId) : review.reviewId != null) return false;
        if (prodId != null ? !prodId.equals(review.prodId) : review.prodId != null) return false;
        if (rating != null ? !rating.equals(review.rating) : review.rating != null) return false;
        if (clientId != null ? !clientId.equals(review.clientId) : review.clientId != null) return false;
        return reviewBody != null ? reviewBody.equals(review.reviewBody) : review.reviewBody == null;
    }

    @Override
    public int hashCode() {
        int result = reviewId != null ? reviewId.hashCode() : 0;
        result = 31 * result + (prodId != null ? prodId.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (clientId != null ? clientId.hashCode() : 0);
        result = 31 * result + (reviewBody != null ? reviewBody.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", prodId=" + prodId +
                ", rating=" + rating +
                ", clientId=" + clientId +
                ", reviewBody=" + reviewBody +
                '}';
    }
}
