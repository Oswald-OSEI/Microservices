package microservice.order.controller;


import microservice.order.DTO.InvoiceDto;
import microservice.order.DTO.OrderDto;
import microservice.order.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private OrderService orderservice;
    public OrderController(OrderService orderService){
        this.orderservice=orderService;
    }

    @PostMapping("/placeOrder")
    public ResponseEntity<InvoiceDto> placeOrder(@RequestBody OrderDto orderDto){
       return ResponseEntity.ok(orderservice.placeOrder(orderDto));
    }

}
