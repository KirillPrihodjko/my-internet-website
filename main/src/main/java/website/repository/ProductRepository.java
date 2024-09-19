package website.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import website.entity.product.ProductCategoryEntity;
import website.entity.product.ProductEntity;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    ProductEntity findProductByName(String name);

    ProductEntity findProductByPrice(double price);

    List<ProductEntity> getAllProductEntitiesByProductCategory(ProductCategoryEntity productCategoryEntity);
}
