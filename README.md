# spring-cloud-learn

from [javinuse.com](https://www.javainuse.com/spring/)

## Eureka Instance Id 설정 국룰

> instance id 가 겹치지 않아야 Eureka에서 다른 Replica 로 구별 할 수 있다.

```yml
spring.application.name: employee-producer

eureka:
  instance:
    instanceId: ${spring.application.name}:${vcap.application.instance_id:${spring.application.instance_id:${random.value}}}
```

![eureka instance id](./images/eureka-instance-id.png)

[see more](https://cloud.spring.io/spring-cloud-netflix/multi/multi__service_discovery_eureka_clients.html#_changing_the_eureka_instance_id)

## Ribbon을 이용해서 LoadBalancer 설정하기

### Ribbon 의존성 추가

* Spring Cloud Starter Ribbon (deprecated, please use spring-cloud-starter-netflix-ribbon)

```xml
<!-- Ribbon -->
<dependency>
  <groupId>org.springframework.cloud</groupId>
  <artifactId>spring-cloud-starter-netflix-ribbon</artifactId>
  <version>2.2.10.RELEASE</version>
</dependency>
```

### RestTemplate를 Bean으로 만든 후, @LoadBalenced 어노테이션 추가

```java
@LoadBalanced
@Bean
RestTemplate getRestTemplate() {
  return new RestTemplate();
}
```

## Hystrix를 이용해서 실패 관용성 ( fault tolerance ) 추가하기

### Hystrix 의존성 추가

* Spring Cloud Starter Hystrix (deprecated, please use spring-cloud-starter-netflix-hystrix)

```xml
<!-- Hystrix -->
<dependency>
  <groupId>org.springframework.cloud</groupId>
  <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
  <version>2.2.10.RELEASE</version>
</dependency>
```

## Feign Client를 이용해서 복잡도 줄이기

### Feign Client 의존성 추가

* Spring Cloud Starter Feign (deprecated, please use spring-cloud-starter-openfeign)

### @EnableFeignClients at EmployeeCustomerApplication.java

```java
@SpringBootApplication
@EnableFeignClients
public class EmployeeCustomerApplication {
```

### Remote Call 서비스 만들기

```java
@FeignClient(name="employee-producer", url="http://localhost:8081")
public interface RemoteCallService {
  @RequestMapping(method=RequestMethod.GET, value="/employee")
  public Employee getData();
}
```

### Controller에 Remote Call Service 연결하기

```java
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
```
