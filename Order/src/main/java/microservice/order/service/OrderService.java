package microservice.order.service;

import microservice.order.DTO.InvoiceDto;
import microservice.order.DTO.OrderDto;
import microservice.order.entity.OrderEntity;
import microservice.order.repository.OrderRepository;
import microservice.proto.grpc.ProductProto;
import microservice.proto.grpc.ProductServiceGrpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderService{
    private OrderRepository orderRepository;
    private final ProductServiceGrpc.ProductServiceBlockingStub productServiceBlockingStub;

    public OrderService(OrderRepository orderRepository, ProductServiceGrpc.ProductServiceBlockingStub productServiceBlockingStub){
        this.orderRepository = orderRepository;
        this.productServiceBlockingStub = productServiceBlockingStub;
    }

    public InvoiceDto placeOrder(OrderDto orderDto){
        //retreive productdetails from product service using gRPC
        long productId = orderDto.getProductId();

        ProductProto.ProductRequest request = ProductProto.ProductRequest.newBuilder()
                .setId(productId)
                .build();

        ProductProto.ProductResponse response = productServiceBlockingStub.getProductById(request);

        ProductProto.Product product = response.getProduct();
        orderRepository.save(new OrderEntity(product.getId(), orderDto.getQuantity(), orderDto.getQuantity()*product.getProductPrice()));

        return new InvoiceDto(LocalDateTime.now(), product.getProductName(), orderDto.getQuantity(), orderDto.getQuantity()*product.getProductPrice());
    }
}
