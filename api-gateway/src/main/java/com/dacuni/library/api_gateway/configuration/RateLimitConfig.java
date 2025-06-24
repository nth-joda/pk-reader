package com.dacuni.library.api_gateway.configuration;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Configuration
public class RateLimitConfig {

    @Bean
    public KeyResolver ipKeyResolver() {
        // Mỗi client được phân theo IP
        return exchange -> Mono.just(
                Objects.requireNonNull(exchange.getRequest()
                                .getRemoteAddress())
                        .getAddress()
                        .getHostAddress()
        );
    }
}