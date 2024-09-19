package website.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import website.core.service.ProductService;
import website.dto.ProductDto;
import website.entity.product.ProductCategoryEntity;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/product")
@RestController
public class ProductController {

    private final ProductService productService;

    @GetMapping("/all")
    @CrossOrigin("*")
    public ResponseEntity<List<ProductDto>> getProduct() {
        List<ProductDto> product = productService.findAll();
        //Thread.sleep(2000);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/getByCategory/{categoryId}")
    @CrossOrigin("*")
    public ResponseEntity<List<ProductDto>> getProductsByCategory(@PathVariable Long categoryId) {
        List<ProductDto> product = productService.getProductsByCategoryId(categoryId);
        //Thread.sleep(2000);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/allCategories")
    @CrossOrigin("*")
    public ResponseEntity<List<ProductCategoryEntity>> getCategories() {
        List<ProductCategoryEntity> categories = productService.getAllCategories();
        //Thread.sleep(2000);
        return ResponseEntity.ok(categories);
    }

/* Create product example
{
    "name":"test1",
    "price":12,
    "productCategory":{
        "id":1
    }
}
 */
    @PostMapping(value = "/create")
    @CrossOrigin("*")
    public ResponseEntity<?> createProduct(@RequestBody ProductDto product) {
        ProductDto productDto = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(productDto);
    }
}
