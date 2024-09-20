package tech.io.sqs_producer.domain.product;

import java.math.BigDecimal;

public class Product {
    private String productName;
    private String productDesc;
    private String productCategory;
    private BigDecimal productPrice;

    public Product(String productName, BigDecimal productPrice, String productCategory, String productDesc) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCategory = productCategory;
        this.productDesc = productDesc;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }
}
