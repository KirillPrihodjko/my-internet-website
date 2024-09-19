package website.core.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import website.dto.ProductDto;
import website.entity.product.ProductCategoryEntity;
import website.entity.product.ProductEntity;
import website.repository.ImageRepository;
import website.repository.ProductCategoryRepository;
import website.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductCategoryRepository productCategoryRepository;
    private final ImageRepository imageRepository;

    public List<ProductDto> findAll() {
        return productRepository.findAll().stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    public List<ProductDto> getProductsByCategoryId(Long categoryId) {
        ProductCategoryEntity productCategoryEntity = productCategoryRepository.findById(categoryId).get();
        return productRepository.getAllProductEntitiesByProductCategory(productCategoryEntity).stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    public ProductDto createProduct(ProductDto productDto) {
        ProductEntity productEntityForSave = convertToEntity(productDto);
        productEntityForSave.setImages(null);
        ProductEntity productEntity = productRepository.save(productEntityForSave);
        productDto.getImages().forEach(
                image -> {
                    image.setProduct(productEntity);
                    imageRepository.save(image);
                }
        );
        return convert(productEntity);
    }

    public List<ProductCategoryEntity> getAllCategories() {
        return productCategoryRepository.findAll();
    }

    private ProductDto convert(ProductEntity entity) {
        // List<Integer> imageIds = entity.getImages().stream().map(ImageEntity::getId).collect(Collectors.toList());
        return new ProductDto(entity.getId(), entity.getName(), entity.getPrice(),
                entity.getProductCategory(), entity.getImages());
    }

    private ProductEntity convertToEntity(ProductDto productDto) {
        // List<ImageEntity> images = productDto.getImageId().stream().map(id->new ImageEntity(id)).collect(Collectors.toList());
        return new ProductEntity(productDto.getId(), productDto.getName(), productDto.getPrice(),
                productDto.getProductCategory(), productDto.getImages());
    }
}
