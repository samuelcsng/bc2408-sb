# bc2408-sb

***
## Bootcamp SpringBoot
***
## Week-9 Day-3 20241002
### Maven

### Spring Boot
### week 10(materials)
  - Spring Boot I
    - Web Fundamentals
      - Clients
      - Servers
      - web layer, web services > java-friendly
      - java, C#, C++
        - Java + Maven vs GO (support cloud)
      - AWS server certificate exam
      - Hosts:Port
        - localhost:port = 127.0.0.1:port
      - URL, DNS
    - Port
      - HTTP: port 80
      - SSH: port 22 ???
      - HTTPS: port 443 ???

- Spring Boot
  - Spring Boot Version 3 -> Spring Version 6
  - mvn spring-boot:run
  - @Controller
  - @ResponseBody
  - @GetMapping(value = "...")



***
## Week-9 Day-4 20241003

- Spring boot pom.xml
  - dependency: devtools
  ```
  <!-- Auto-recompile and restart server -->
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-devtools</artifactId>
      <scope>runtime</scope>
    </dependency>
  ```

- JSON
  - Chrome extension
    - JSON formatter
  - serialization deserialization
- List.of()
- DTO (Data Transfer Object), represents JSON object

- Model > Mapper > DTO > Controller
- Controller > DTO Mapper( Model ) 
- API Gateway

***
## Week-9 Day-5 20241004

- AWS(Region > Availability Zone) Server EC2
- pom.xml
  -<scope> test </scope>
  -<build> ...

- AWS Certification Pathways
  - Solution architect
  - Software Development Engineer

- Server EC2
  - Web Layer > Controller > Service > Repository
- Server RDB-PostgreSQL

- @RestController = @Controller + @ResponseBody


***
## Week-10 Day-1 20241007

- @Autowired(required = false)
- Single Thread vs Multi-Thread
- Spring vs Spring Boot
- Spring Context
- Database Dependency
  JPA + PostgreSQL DB
- Spring Concept
  - bean
  - IoC (Inversion of Control)
  - dependency injection

***
## Week-10 Day-2 20241008

- @Bean
  - @Component
    - @Controller
    - @Service
    - @Repository
- @Configuration
- @Autowired
- @RestControllerAdvice
  - @ExceptionHandler({RestClientException.class})
- @PathVariable vs @RequestParam()
- @ResponseStatus(...)
- Restful API
  - URI -> resource
  - Get, Post, Delete, Put
    - @DeleteMapping -> SQL: delete from
    - @PutMapping -> SQL: update
    - @GetMapping -> SQL: Select
    - @PostMapping -> SQL: insert into
- JSON payload of



***
## Week-10 Day-3 20241009
### Career Day
- CV
- JobsDB
- LinkedIn
- BA vs development
- In-house(stable, ) vs Vendor(MNC) vs System Integrator(SI)(or Solution Provider)
- Criteria
  - Tech Stacks > Project Scale > Job Contenct > Company




***
## Week-10 Day-4 20241010
- jobsDB
- career related

- Spring Boot
  - Controller call Service, Service call Repository
  - DTO mapper (combine multiple SQL-DB Tables (using Join or ...) to one single DTO and send to consumer client request)



***
## Week-10 Day-5 20241011
### Holiday




***
## Week-11 Day-1 20241014
- mvn compile (main code)
- mvn test-compile (test code)
- mvn test (main compile + test compile + test), test -> bean cycle + server starts (i.e. check autowired)
- mvn package (all the above + generate jar)
- mvn install (all the above + copy the jar from project to .m2)

- @WebMvcTest(...)
  - @MockBean

- JPA
  - Hibernate


***
## Week-11 Day-2 20241015
// UserDTO.class (Controller Layer)
// User.class (Service Layer)
// UserEntity.class (Repository Layer)


***
## Week-11 Day-3 20241016
- Spring Boot Exercise 2

***
## Week-11 Day-4 20241017
- CommandLineRunner

- @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
- @ManyToOne
- @JoinColumn(name = "...", nullable = false)
- @Builder.Default
  @OneToMany(mappedBy = "...", cascade = CascadeType.ALL, fetch = FetchType.LAZY)

- Lombok
  @Data (for mutable objects) vs @Value(for immutable objects)
***



## Week-11 Day-5 20241018
- exercise 3

## Week-12 Day-1 20241021
- exercise 3
- Generic API Response ApiResp<T>
``` public class ApiResp<T>{
private String code;
private String message;
private List<T> data;
}```

### Week 11 Notes
- CommandLineRunner
- Scheduled Task
  - Cron Expressions
  - Fixed Delay vs Fixed Rate
  - @EnableScheduling
  - @Scheduled(fixedDelay = ...), @Scheduled(fixedRate = ...) // in ms

- JPQL (Java Persistence Query Language)
  - @Query(...)
- Native Query (traditional SQL)
  - @Query(..., nativeQuery = true)

- Update Query
  - @Transactional
  - EntityManager



## Week-12 Day-2 20241022
- exercise 3
- final project


## Week-12 Day-3 20241023
- Dependency Injection (Constructor Injection)
  - more classes, easier test by using @Mock
- responseEntity = restTemplate.getForEntity("url", String.class);
- responseEntity.getHearders()
- responseEntity.getBody() = .getForBody()
- CookieManager

- Entity, Repository
  ```
  @Entity
  @Table()

  @Repository
  interface EntityRepository extends JpaRepository<Entity,Long> {
    ...
    Optional<Entity> findByAttribute(field); // refer to SQL concept
    ...
  }
  ```
- CommandLineRunner
  ```
  @Component
  AppStartRunner implements CommandLineRunner {
    ...
    @Override
    public void run() {}
  }
  ```

## Week-12 Day-4 20241024

## Week-12 Day-5 20241025