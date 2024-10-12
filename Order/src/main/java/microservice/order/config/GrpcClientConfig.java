package microservice.order.config;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import microservice.proto.grpc.ProductServiceGrpc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpcClientConfig {

    @Bean
    public ManagedChannel managedChannel() {
        // Replace "localhost" with the actual address of the product service and port with the correct port
        return ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext()
                .build();
    }

    @Bean
    public ProductServiceGrpc.ProductServiceBlockingStub productServiceBlockingStub(ManagedChannel managedChannel) {
        return ProductServiceGrpc.newBlockingStub(managedChannel);
    }
}
