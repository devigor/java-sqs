package tech.io.sqs_consumer.domain.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_products")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String productName;

    private String productDesc;

    private String productCategory;

    private BigDecimal productPrice;


    public Product(String productName, String productDesc, String productCategory, BigDecimal productPrice) {
        this.productName = productName;
        this.productDesc = productDesc;
        this.productCategory = productCategory;
        this.productPrice = productPrice;
    }
}
