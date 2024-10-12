package microservice.product.controllers;

import microservice.product.dto.ProductDto;
import microservice.product.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService=productService;
    }

    @GetMapping("getProduct/{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable long id){
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PostMapping("addProduct/")
    public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto){
        return ResponseEntity.ok(productService.addProduct(productDto));
    }
}
