package com.arthur.employeecustomer.controller;

import java.io.IOException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ConsumerControllerClient {

  public void getEmployee() {
    String baseUrl = "http://localhost:8080/employee";
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> response = null;

    try {
      response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class);
    } catch (Exception ex) {
      System.out.println(ex);
    }
    System.out.println(response.getBody());
  }

  private static HttpEntity<?> getHeaders() throws IOException {
    HttpHeaders headers = new HttpHeaders();
    headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
    return new HttpEntity<>(headers);
  }
}
