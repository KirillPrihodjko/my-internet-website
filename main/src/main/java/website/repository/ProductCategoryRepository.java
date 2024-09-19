package website.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import website.entity.product.ProductCategoryEntity;
import website.entity.product.ProductEntity;

import java.util.List;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategoryEntity, Long> {

    ProductCategoryEntity findProductCategoryByCategoryName(String categoryName);

    ProductCategoryEntity findProductCategoryByProducts(List<ProductEntity> product);
}
