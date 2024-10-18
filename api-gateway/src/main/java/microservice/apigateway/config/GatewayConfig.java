package microservice.apigateway.config;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                // Route for the product service
                .route("product", r -> r.path("/products/**")  // Matches all paths starting with /products/
                        .uri("lb://PRODUCT")) // Uses load balancer to route to PRODUCT-SERVICE
                // Route for the order service
                .route("order", r -> r.path("/orders/**")  // Matches all paths starting with /orders/
                        .uri("lb://ORDER")) // Uses load balancer to route to ORDER-SERVICE
                .build();
    }
}

