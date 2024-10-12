package microservice.product.services;

import io.grpc.stub.StreamObserver;
import microservice.product.ProductRepository.ProductRepository;
import microservice.product.entities.ProductEntity;
import microservice.proto.grpc.ProductProto;
import microservice.proto.grpc.ProductServiceGrpc;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.stereotype.Service;

@GrpcService
public class ProductServiceGRPC extends ProductServiceGrpc.ProductServiceImplBase{
    private final ProductRepository productRepository;

    public ProductServiceGRPC(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public void getProductById(ProductProto.ProductRequest request, StreamObserver<ProductProto.ProductResponse> responseObserver) {
        long productId = request.getId();

        ProductEntity productEntity = productRepository.findById(productId).orElseThrow(null);
        if(productEntity!=null){
            ProductProto.Product product = ProductProto.Product.newBuilder()
                    .setId(productEntity.getId())
                    .setProductName(productEntity.getProductName())
                    .setProductDescription(productEntity.getProductDescription())
                    .setProductPrice(productEntity.getProductPrice())
                    .setProductQuantity(productEntity.getProductQuantity())
                    .build();
            ProductProto.ProductResponse response = ProductProto.ProductResponse.newBuilder()
                    .setProduct(product)
                    .build();
        }else{
            responseObserver.onError(new RuntimeException("Product with ID"+ productId + "doesn't exist"));
        }

        //Complete the RPC call
        responseObserver.onCompleted();

    }
}
