package com.example.test.test_jpa_database.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.test.test_jpa_database.model.TestUser;
import com.example.test.test_jpa_database.repository.TestUserRepository;

@Service
public class TestUserService {

  @Autowired
  private TestUserRepository testUserRepository;

  public List<TestUser> getAllTestUsers() {
    return testUserRepository.findAll();
  }

  public TestUser saveTestUser(TestUser testUser) {
    return testUserRepository.save(testUser);
  }

  public long countTestUser(){
    return testUserRepository.count();
  }

}
