package tech.io.sqs_consumer.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;
import tech.io.sqs_consumer.domain.product.ProductDTO;

@Slf4j
@Service
public class SqsConsumer {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    ProductService productService;

    @SqsListener("${sqs.queue.name}")
    public void consumeSqsMessage(String message) throws JsonProcessingException {
        log.info("message receive: {}", message);

        ProductDTO productDTO = objectMapper.readValue(message, ProductDTO.class);
        productService.saveNewProduct(productDTO);
    }
}
