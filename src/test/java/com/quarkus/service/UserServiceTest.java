package com.quarkus.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.quarkus.entity.UserEntity;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@QuarkusTest
class UserServiceTest {

  @Autowired
  private UserService userService;

  @Test
  public void findByEmailTest() {

    //given
    String email = "test1@gmail.com";

    //when
    UserEntity userEntity = userService.findByEmail(email);

    //then
    assertEquals("test1", userEntity.getName());
  }
}
