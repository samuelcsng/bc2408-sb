package com.bootcamp.demo.demo_sb_restapi.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo.demo_sb_restapi.entity.UserEntity;
import com.bootcamp.demo.demo_sb_restapi.exception.JPHRestClientException;
import com.bootcamp.demo.demo_sb_restapi.mapper.JPHMapper;
import com.bootcamp.demo.demo_sb_restapi.model.Cat;
import com.bootcamp.demo.demo_sb_restapi.model.dto.jph.UserDTO;
import com.bootcamp.demo.demo_sb_restapi.repository.UserRepository;
import com.bootcamp.demo.demo_sb_restapi.service.JPHService;
import com.bootcamp.demo.demo_sb_restapi.util.Scheme;
import com.bootcamp.demo.demo_sb_restapi.util.Url;

@Service // Component annotation -> bean
public class JPHServiceImpl implements JPHService {
  @Autowired
  @Qualifier(value = "JPHRestTemplate") // inject bean by specific bean name
  private RestTemplate restTemplate;

  @Autowired
  private Cat cat; // Vincent

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private JPHMapper jphMapper;

  // ! @Value (inject from yml) is similar to @Autowired (inject from Spring Context)
  // Both of them has to be executed before server start
  @Value("${api.jph.domain}")
  private String jphDomain;

  @Value("${api.jph.endpoints.users}")
  private String usersEndpoint;


  // @Override
  // public List<UserDTO> getUsers() {
  // UserDTO[] users = new RestTemplate().getForObject(
  // "https://jsonplaceholder.typicode.com/users", UserDTO[].class);
  // // return List.of(users); // to list
  // // return List.of(users).stream() //
  // // .collect(Collectors.toList()) //
  // // ;
  // // return Stream.of(users) //
  // // .collect(Collectors.toList()) //
  // // ;
  // return Arrays.stream(users) //
  // .collect(Collectors.toList()) //
  // ;
  // }

  @Override
  public List<UserDTO> getUsers() {
    // ! You can use UriComponentBuilder directly
    String url = Url.builder() //
        .scheme(Scheme.HTTPS) //
        .domain(this.jphDomain) //
        .endpoint(this.usersEndpoint) //
        .build() //
        .toUriString() //
    ;
    System.out.println("url=" + url);
    // Happy Path
    UserDTO[] users;
    try {
    users = this.restTemplate.getForObject(url, UserDTO[].class); // 10ms
    } catch (RestClientException e) {
      throw new JPHRestClientException("Json Placeholder Exception.");
    }
    return List.of(users);
  }

  // @Override
  // public List<UserDTO> saveUsers(List<UserDTO> userDTOs){
  // return UserRepository.saveAll(userDTOs);
  // }

  @Override
  public List<UserEntity> saveUsers() {
    // Call External JPH service
    List<UserDTO> userDTOs = this.getUsers();
    return this.saveUsers(userDTOs);
  }

  private List<UserEntity> saveUsers(List<UserDTO> userDTOs) {
    // Mapper: from List<UserDTO> to List<UserEntity>
    List<UserEntity> userEntities = userDTOs.stream() //
        // .map(e -> JPHMapper.map(e)) //
        .map(e -> this.jphMapper.map(e)) //
        .collect(Collectors.toList()) //
    ;
    return userRepository.saveAll(userEntities);
  }

  // saveUser(int id)
  // -> stream filter -> save()


}
