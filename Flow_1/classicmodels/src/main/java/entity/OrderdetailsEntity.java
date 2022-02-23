package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "orderdetails", schema = "classicmodels", catalog = "")
@IdClass(OrderdetailsEntityPK.class)
public class OrderdetailsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "orderNumber", nullable = false)
    private int orderNumber;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "productCode", nullable = false, length = 15)
    private String productCode;
    @Basic
    @Column(name = "quantityOrdered", nullable = false)
    private int quantityOrdered;
    @Basic
    @Column(name = "priceEach", nullable = false, precision = 0)
    private double priceEach;
    @Basic
    @Column(name = "orderLineNumber", nullable = false)
    private short orderLineNumber;

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public int getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(int quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public double getPriceEach() {
        return priceEach;
    }

    public void setPriceEach(double priceEach) {
        this.priceEach = priceEach;
    }

    public short getOrderLineNumber() {
        return orderLineNumber;
    }

    public void setOrderLineNumber(short orderLineNumber) {
        this.orderLineNumber = orderLineNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderdetailsEntity that = (OrderdetailsEntity) o;
        return orderNumber == that.orderNumber && quantityOrdered == that.quantityOrdered && Double.compare(that.priceEach, priceEach) == 0 && orderLineNumber == that.orderLineNumber && Objects.equals(productCode, that.productCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNumber, productCode, quantityOrdered, priceEach, orderLineNumber);
    }
}
