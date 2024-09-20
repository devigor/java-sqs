package tech.io.sqs_consumer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.io.sqs_consumer.domain.product.Product;
import tech.io.sqs_consumer.domain.product.ProductDTO;
import tech.io.sqs_consumer.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public void saveNewProduct(ProductDTO dto) {
        Product product = Product.builder()
                .productName(dto.productName())
                .productCategory(dto.productCategory())
                .productDesc(dto.productDesc())
                .productPrice(dto.productPrice())
                .build();

        productRepository.save(product);
    }
}
