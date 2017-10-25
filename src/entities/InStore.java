package entities;

import sun.nio.cs.Surrogate;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "in_store")
public class InStore implements Serializable{
    @Id
    @Column(name="rec_id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "instore_gen")
    @SequenceGenerator(name = "instore_gen", sequenceName = "rec_seq")
    private Integer recId;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "store_id", nullable = false)
    private Store storeId;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "prod_id", nullable = false)
    private Product prodId;

    @Column(name = "num_of_products", nullable = false)
    private Integer numberOfProducts;

    @Column(name = "prod_size")
    private String prodSize;

    @Column(name = "color")
    private Integer size;

    public InStore() { }

    public InStore(Store storeId, Product prodId, Integer numberOfProducts, String prodSize, Integer size) {
        this.storeId = storeId;
        this.prodId = prodId;
        this.numberOfProducts = numberOfProducts;
        this.prodSize = prodSize;
        this.size = size;
    }

    public Integer getRecId() {
        return recId;
    }

    public void setRecId(Integer recId) {
        this.recId = recId;
    }

    public Store getStoreId() {
        return storeId;
    }

    public void setStoreId(Store storeId) {
        this.storeId = storeId;
    }

    public Product getProdId() {
        return prodId;
    }

    public void setProdId(Product prodId) {
        this.prodId = prodId;
    }

    public Integer getNumberOfProducts() {
        return numberOfProducts;
    }

    public void setNumberOfProducts(Integer numberOfProducts) {
        this.numberOfProducts = numberOfProducts;
    }

    public String getProdSize() {
        return prodSize;
    }

    public void setProdSize(String prodSize) {
        this.prodSize = prodSize;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InStore)) return false;

        InStore inStore = (InStore) o;

        if (!recId.equals(inStore.recId)) return false;
        if (!storeId.equals(inStore.storeId)) return false;
        if (!prodId.equals(inStore.prodId)) return false;
        if (numberOfProducts != null ? !numberOfProducts.equals(inStore.numberOfProducts) : inStore.numberOfProducts != null)
            return false;
        if (prodSize != null ? !prodSize.equals(inStore.prodSize) : inStore.prodSize != null) return false;
        return size != null ? size.equals(inStore.size) : inStore.size == null;
    }

    @Override
    public int hashCode() {
        int result = recId.hashCode();
        result = 31 * result + storeId.hashCode();
        result = 31 * result + prodId.hashCode();
        result = 31 * result + (numberOfProducts != null ? numberOfProducts.hashCode() : 0);
        result = 31 * result + (prodSize != null ? prodSize.hashCode() : 0);
        result = 31 * result + (size != null ? size.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "InStore{" +
                "recId=" + recId +
                ", storeId=" + storeId +
                ", prodId=" + prodId +
                ", numberOfProducts=" + numberOfProducts +
                ", prodSize='" + prodSize + '\'' +
                ", size=" + size +
                '}';
    }
}
