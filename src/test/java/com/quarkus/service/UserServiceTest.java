package com.quarkus.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.quarkus.entity.UserEntity;
import io.quarkus.arc.profile.IfBuildProfile;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@QuarkusTest
@IfBuildProfile("test")
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

  @Test
  public void userInfoUpdate() {
    //given
    UserEntity user = UserEntity.builder()
        .name("test999")
        .age(30)
        .email("test1@gmail.com")
        .build();

    //when
    UserEntity resultUser = userService.update(user);

    //then
    assertNotNull(resultUser.getSeq());
    assertEquals(user.getName(), resultUser.getName());
    assertEquals(user.getAge(), resultUser.getAge());
  }
}
