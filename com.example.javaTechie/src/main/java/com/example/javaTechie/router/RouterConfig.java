package com.example.javaTechie.router;

import com.example.javaTechie.handler.CustomerHandler;
import com.example.javaTechie.handler.CustomerStreamHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfig {
    @Autowired
    private CustomerHandler handler;
    @Autowired
    private CustomerStreamHandler streamhandler;

    @Bean
    public RouterFunction<ServerResponse> routerFunction(){
        return RouterFunctions.route()
                .GET("/router/customers", handler::loadCustomers)
                .GET("router/customer/stream",streamhandler::getCustomer)
                .GET("/router/customer/{input}", handler:: findCustomer)
                .POST("/router/customer/save", handler::saveCustomer)
                .build();
    }


}
