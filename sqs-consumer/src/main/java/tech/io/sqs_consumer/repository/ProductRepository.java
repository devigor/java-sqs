package tech.io.sqs_consumer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tech.io.sqs_consumer.domain.product.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
