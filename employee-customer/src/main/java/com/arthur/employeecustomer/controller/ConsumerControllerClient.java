package com.arthur.employeecustomer.controller;

import java.io.IOException;

import com.arthur.employeecustomer.feign.RemoteCallService;
import com.arthur.employeecustomer.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class ConsumerControllerClient {

  @Autowired
  private RemoteCallService loadBalancer;

  public void getEmployee() {

    try {
      // response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class);
      Employee emp = loadBalancer.getData();
      System.out.println(emp.getEmpId());
    } catch (Exception ex) {
      System.out.println(ex);
    }
  }
}
