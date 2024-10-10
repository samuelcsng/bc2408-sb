package com.example.test.test_jpa_database.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.test.test_jpa_database.model.TestUser;
import com.example.test.test_jpa_database.service.TestUserService;

@RestController
@RequestMapping(value = "/api/testusers")
public class TestUserController {

  @Autowired
  private TestUserService testUserService;

  @GetMapping
  public List<TestUser> getAllTestUsers() {
    return testUserService.getAllTestUsers();
  }

  @PostMapping
  public TestUser createTestUser(TestUser testUser) {
    return testUserService.saveTestUser(testUser);
  }

  @GetMapping(value = "/count")
  public long getCountTestUsers() {
    return testUserService.countTestUser();
  }

}
