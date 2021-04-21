package com.paulevers.spotsgateway;

import com.paulevers.spotsgateway.auth.AuthFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpotsGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpotsGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder, AuthFilter authFilter) {
		return builder.routes()
				.route(r -> r.path("/spots/**")
						.filters(f -> f.filter(authFilter.apply(new AuthFilter.Config())))
						.uri("lb://SPOT-SERVICE"))
				.build();
	}
}
