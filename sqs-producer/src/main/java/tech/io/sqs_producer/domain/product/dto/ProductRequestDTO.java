package tech.io.sqs_producer.domain.product.dto;

import java.math.BigDecimal;

public record ProductRequestDTO(
        String productName,
        String productDesc,
        String productCategory,
        BigDecimal productPrice
) {
}
