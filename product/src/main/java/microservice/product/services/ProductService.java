package microservice.product.services;


import microservice.product.ProductRepository.ProductRepository;
import microservice.product.dto.ProductDto;
import microservice.product.entities.ProductEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
private ProductRepository productRepository;

    private ProductService(ProductRepository productRepository){
    this.productRepository = productRepository;
    }

    //To add new product
    public ProductDto addProduct(ProductDto productDto){
        return convertToDto(productRepository.save(convertToEntity(productDto)));
    }

    //To get a specific product
    public ProductDto getProductById(long id){
        return convertToDto(productRepository.findById(id).orElseThrow(null));
    }

    //To retrieve all products
    public List<ProductDto> getAllProducts(){
        return productRepository.findAll().
                                  stream().
                                  map(this::convertToDto).
                                  toList();

    }

    //To update a product
    public ProductDto updateProduct(ProductDto productDto){
        ProductEntity productEntity = productRepository.findById(productDto.getId()).orElseThrow(null);
        if(productEntity != null){
            productEntity.setProductName(productDto.getProductName());
            productEntity.setProductDescription(productDto.getProductDescription());
            productEntity.setProductPrice(productDto.getProductPrice());
            productEntity.setProductQuantity(productDto.getProductQuantity());
        }
        return convertToDto(productEntity);
    }

    //Delete by id
    public void deleteProduct(long id){
        productRepository.deleteById(id);
    }



    //convert entity to dto
    private ProductDto convertToDto(ProductEntity productEntity){
        return new ProductDto(productEntity.getId(),
                              productEntity.getProductName(),
                              productEntity.getProductDescription(),
                              productEntity.getProductPrice(),
                              productEntity.getProductQuantity());
    }
    //convert dto to entity
    private ProductEntity convertToEntity(ProductDto productDto){
        return new ProductEntity(productDto.getId(),
                                 productDto.getProductName(),
                                 productDto.getProductDescription(),
                                 productDto.getProductPrice(),
                                 productDto.getProductQuantity());
    }
}
