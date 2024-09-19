package website.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import website.entity.product.ImageEntity;

@Repository
public interface ImageRepository extends JpaRepository<ImageEntity, Integer> {


}
