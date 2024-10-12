package microservice.order.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDateTime orderDate = LocalDateTime.now();
    private long productId;
    private int productQuantity;
    private int totalCost;

    public OrderEntity(long productId, int productQuantity, int totalCost ){
        this.productId = productId;
        this.productQuantity = productQuantity;
        this.totalCost = totalCost;
    }
}
