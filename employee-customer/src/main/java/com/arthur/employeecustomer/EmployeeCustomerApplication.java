package com.arthur.employeecustomer;

import com.arthur.employeecustomer.controller.ConsumerControllerClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EmployeeCustomerApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(EmployeeCustomerApplication.class, args);

    ConsumerControllerClient consumerControllerClient = ctx.getBean(ConsumerControllerClient.class);
    System.out.println(consumerControllerClient);
    consumerControllerClient.getEmployee();
	}

}
