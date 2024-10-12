package microservice.order.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDto {

    private LocalDateTime orderDate;

    private String productName;

    private int quantity;

    private int totalCost;



}
