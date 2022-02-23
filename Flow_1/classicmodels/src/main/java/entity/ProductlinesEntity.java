package entity;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "productlines", schema = "classicmodels", catalog = "")
public class ProductlinesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "productLine", nullable = false, length = 50)
    private String productLine;
    @Basic
    @Column(name = "textDescription", nullable = true, length = 4000)
    private String textDescription;
    @Basic
    @Column(name = "htmlDescription", nullable = true, length = -1)
    private String htmlDescription;
    @Basic
    @Column(name = "image", nullable = true)
    private byte[] image;

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getTextDescription() {
        return textDescription;
    }

    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
    }

    public String getHtmlDescription() {
        return htmlDescription;
    }

    public void setHtmlDescription(String htmlDescription) {
        this.htmlDescription = htmlDescription;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductlinesEntity that = (ProductlinesEntity) o;
        return Objects.equals(productLine, that.productLine) && Objects.equals(textDescription, that.textDescription) && Objects.equals(htmlDescription, that.htmlDescription) && Arrays.equals(image, that.image);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(productLine, textDescription, htmlDescription);
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }
}
