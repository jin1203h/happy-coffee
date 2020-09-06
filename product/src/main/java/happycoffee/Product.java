package happycoffee;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Product_table")
public class Product {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long productId;
    private String productName;
    private Long productPrice;
    private Integer productCnt;
    private String producctKind;

    @PostPersist
    public void onPostPersist(){
        ProductRegistered productRegistered = new ProductRegistered();
        BeanUtils.copyProperties(this, productRegistered);
        productRegistered.publishAfterCommit();


        ProductOutOfStock productOutOfStock = new ProductOutOfStock();
        BeanUtils.copyProperties(this, productOutOfStock);
        productOutOfStock.publishAfterCommit();


    }

    @PostUpdate
    public void onPostUpdate(){
        ProductChanged productChanged = new ProductChanged();
        BeanUtils.copyProperties(this, productChanged);
        productChanged.publishAfterCommit();


    }


    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    public Long getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Long productPrice) {
        this.productPrice = productPrice;
    }
    public Integer getProductCnt() {
        return productCnt;
    }

    public void setProductCnt(Integer productCnt) {
        this.productCnt = productCnt;
    }
    public String getProducctKind() {
        return producctKind;
    }

    public void setProducctKind(String producctKind) {
        this.producctKind = producctKind;
    }




}
