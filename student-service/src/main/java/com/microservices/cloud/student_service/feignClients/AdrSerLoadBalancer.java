//package com.microservices.cloud.student_service.feignClients;
//
//import feign.Feign;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
//import org.springframework.context.annotation.Bean;
//
//@LoadBalancerClient(name = "address-service")
//public class AdrSerLoadBalancer {
//
//    @LoadBalanced
//    @Bean
//    public Feign.Builder feignBuilder(){
//        return Feign.builder();
//    }
//}
