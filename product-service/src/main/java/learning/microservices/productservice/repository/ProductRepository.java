package learning.microservices.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import learning.microservices.productservice.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    
}
