package com.arthur.employeecustomer;

import com.arthur.employeecustomer.controller.ConsumerControllerClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
public class EmployeeCustomerApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(EmployeeCustomerApplication.class, args);

    ConsumerControllerClient consumerControllerClient = ctx.getBean(ConsumerControllerClient.class);
    System.out.println(consumerControllerClient);
    consumerControllerClient.getEmployee();
	}

    @LoadBalanced
    @Bean
    RestTemplate getRestTemplate() {
      return new RestTemplate();
    }
}
