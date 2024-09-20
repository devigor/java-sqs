package tech.io.sqs_producer.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.io.sqs_producer.domain.product.Product;
import tech.io.sqs_producer.domain.product.dto.ProductRequestDTO;
import tech.io.sqs_producer.service.Sqs;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Value("${stage.name}")
    private String env;

    @Value("${infra.localstack.url}")
    private String localStackUrl;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    Sqs sqsService;

    @PostMapping("/create")
    ResponseEntity postProduct(@RequestBody ProductRequestDTO data) throws JsonProcessingException {
        Product product = new Product(
                data.productName(),
                data.productPrice(),
                data.productCategory(),
                data.productDesc()
        );

        String productJson = objectMapper.writeValueAsString(product);
        sqsService.sendMessage(productJson);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
