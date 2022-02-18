package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "products", schema = "classicmodels", catalog = "")
public class ProductsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "productCode", nullable = false, length = 15)
    private String productCode;
    @Basic
    @Column(name = "productName", nullable = false, length = 70)
    private String productName;
    @Basic
    @Column(name = "productLine", nullable = false, length = 50)
    private String productLine;
    @Basic
    @Column(name = "productScale", nullable = false, length = 10)
    private String productScale;
    @Basic
    @Column(name = "productVendor", nullable = false, length = 50)
    private String productVendor;
    @Basic
    @Column(name = "productDescription", nullable = false, length = -1)
    private String productDescription;
    @Basic
    @Column(name = "quantityInStock", nullable = false)
    private short quantityInStock;
    @Basic
    @Column(name = "buyPrice", nullable = false, precision = 0)
    private double buyPrice;
    @Basic
    @Column(name = "MSRP", nullable = false, precision = 0)
    private double msrp;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getProductScale() {
        return productScale;
    }

    public void setProductScale(String productScale) {
        this.productScale = productScale;
    }

    public String getProductVendor() {
        return productVendor;
    }

    public void setProductVendor(String productVendor) {
        this.productVendor = productVendor;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public short getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(short quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public double getMsrp() {
        return msrp;
    }

    public void setMsrp(double msrp) {
        this.msrp = msrp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductsEntity that = (ProductsEntity) o;
        return quantityInStock == that.quantityInStock && Double.compare(that.buyPrice, buyPrice) == 0 && Double.compare(that.msrp, msrp) == 0 && Objects.equals(productCode, that.productCode) && Objects.equals(productName, that.productName) && Objects.equals(productLine, that.productLine) && Objects.equals(productScale, that.productScale) && Objects.equals(productVendor, that.productVendor) && Objects.equals(productDescription, that.productDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productCode, productName, productLine, productScale, productVendor, productDescription, quantityInStock, buyPrice, msrp);
    }
}
