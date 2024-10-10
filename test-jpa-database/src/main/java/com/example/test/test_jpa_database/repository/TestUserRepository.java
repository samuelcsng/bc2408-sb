package com.example.test.test_jpa_database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.test.test_jpa_database.model.TestUser;

public interface TestUserRepository extends JpaRepository<TestUser, Long> {
  
}
