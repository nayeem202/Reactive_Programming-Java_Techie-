package com.example.javaTechie.handler;

import com.example.javaTechie.dao.CustomerDao;
import com.example.javaTechie.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerStreamHandler {
    @Autowired
    private CustomerDao dao;
    public Mono<ServerResponse> getCustomer(ServerRequest request){
        Flux<Customer> customerStream = dao.getCustomerStream();
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(customerStream, Customer.class);
    }




}
