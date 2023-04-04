package com.hexagonalarchi.demo.infra.configuration;

import com.hexagonalarchi.demo.DemoApplication;
import com.hexagonalarchi.demo.domain.ports.OrderRepository;
import com.hexagonalarchi.demo.domain.service.DomainOrderService;
import com.hexagonalarchi.demo.domain.service.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = DemoApplication.class)
public class BeanConfiguration {

    @Bean
    OrderService orderService(final OrderRepository orderRepository) {
        return new DomainOrderService(orderRepository);
    }
}
