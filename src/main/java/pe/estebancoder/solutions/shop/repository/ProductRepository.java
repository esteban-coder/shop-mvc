package pe.estebancoder.solutions.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.estebancoder.solutions.shop.entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    //new ProductRepositoryImpl()  -> [ProductRepository]
}
