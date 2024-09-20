package tech.io.sqs_consumer.domain.product;

import java.math.BigDecimal;

public record ProductDTO(
        String productName,
        String productDesc,
        String productCategory,
        BigDecimal productPrice
) {
}
