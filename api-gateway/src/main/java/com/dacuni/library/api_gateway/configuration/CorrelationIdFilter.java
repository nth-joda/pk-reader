package com.dacuni.library.api_gateway.configuration;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
public class CorrelationIdFilter implements WebFilter {
    private static final String CORR_ID = "X-Correlation-Id";
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        String corrId = exchange.getRequest().getHeaders()
                .getFirst(CORR_ID);
        if (corrId == null) {
            corrId = UUID.randomUUID().toString();
        }
        MDC.put(CORR_ID, corrId);
        return chain.filter(exchange)
                .doFinally(sig -> MDC.remove(CORR_ID));
    }
}
