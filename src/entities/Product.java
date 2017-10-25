package entities;

import javax.persistence.*;
import java.sql.Blob;

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prod_gen")
    @SequenceGenerator(name = "prod_gen", sequenceName = "products_seq")
    @Column(name = "prod_id", nullable = false, unique = true)
    private Integer prodId;

    @Column(name = "prod_name", nullable = false, unique = true)
    private String prodName;

    @Column(name = "prod_pic", nullable = false)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "prod_pic", referencedColumnName = "pic_id")
    private Picture prodPic;

    @Column(name = "prod_prce")
    private Integer prodPrice;

    public Product() { }

    public Product(String prodName, Picture prodPic, Integer prodPrice) {
        this.prodName = prodName;
        this.prodPic = prodPic;
        this.prodPrice = prodPrice;
    }

    public Integer getProdId() {
        return prodId;
    }

    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public Picture getProdPic() {
        return prodPic;
    }

    public void setProdPic(Picture prodPic) {
        this.prodPic = prodPic;
    }

    public Integer getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(Integer prodPrice) {
        this.prodPrice = prodPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (!prodId.equals(product.prodId)) return false;
        if (!prodName.equals(product.prodName)) return false;
        if (!prodPic.equals(product.prodPic)) return false;
        return prodPrice.equals(product.prodPrice);
    }

    @Override
    public int hashCode() {
        int result = prodId.hashCode();
        result = 31 * result + prodName.hashCode();
        result = 31 * result + prodPic.hashCode();
        result = 31 * result + prodPrice.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "prodId=" + prodId +
                ", prodName='" + prodName + '\'' +
                ", prodPic=" + prodPic +
                ", prodPrice=" + prodPrice +
                '}';
    }
}
