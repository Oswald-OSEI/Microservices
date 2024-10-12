package microservice.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    Long id;
    String productName;
    String productDescription;
    int productPrice;
    int productQuantity;
}
