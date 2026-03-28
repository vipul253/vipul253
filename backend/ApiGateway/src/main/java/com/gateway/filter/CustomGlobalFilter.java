package com.gateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class CustomGlobalFilter implements GlobalFilter, Ordered {

    private static final Logger logger = LoggerFactory.getLogger(CustomGlobalFilter.class);

    @Override
    //Mono<Void> should be used for Publishers that just completes without any value. 
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // Pre-filter logic: Modify the request (e.g., add a header, log details)
        logger.info("CustomGlobalFilter executed (pre): Request path = {}", exchange.getRequest().getPath());
        System.out.println("before forward");
        // You can add headers to the request like this:
        // exchange.getRequest().mutate().header("X-Custom-Header", "value").build();

        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            // Post-filter logic: Modify the response (e.g., add a header, log details)
            logger.info("CustomGlobalFilter executed (post): Response status = {}", exchange.getResponse().getStatusCode());
            System.out.println("after forward");
        }));
    }

    // Define the order in which this filter should run. Lower value has higher priority.
    @Override
    public int getOrder() {
        return -1; // Run before other filters (e.g., built-in load balancer filter)
    }
}
