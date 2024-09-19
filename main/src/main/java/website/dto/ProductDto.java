package website.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import website.entity.product.ImageEntity;
import website.entity.product.ProductCategoryEntity;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private Integer id;
    private String name;
    private double price;
    private ProductCategoryEntity productCategory;
    private List<ImageEntity> images;
}
