package com.example.JavatechieTest;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxExcercise {

    @Test
    public void testMono(){
        Mono<?> monoString = Mono.just("Hello World")
                .then(Mono.error(new RuntimeException("Error occured")).log());
        monoString.subscribe(System.out::print, e -> e.getMessage());
    }

    @Test
    public void TestFlux(){
        Flux<String> fluxString = Flux.just("Spring", "SpringBoot", "Hibernate", "MicroService")
                .concatWithValues("Jpa")
                .concatWith(Flux.error(new RuntimeException("Flux Error occured")))
                .concatWithValues("RSA")
                .log();
        fluxString.subscribe(System.out::print, e -> e.getMessage());
    }




}
