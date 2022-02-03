package com.arthur.employeecustomer.feign;

import com.arthur.employeecustomer.model.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="employee-producer", url="http://localhost:8081")
public interface RemoteCallService {
  @RequestMapping(method=RequestMethod.GET, value="/employee")
  public Employee getData();
}
