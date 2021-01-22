package com.quarkus.controller;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

@QuarkusTest
class UserControllerTest {

  @Test
  public void testFindById() {
    given()
        .when().get("/user/1")
        .then()
        .statusCode(200)
        .body("name", equalTo("test1"))
        .body("email", equalTo("test1@gmail.com"));
  }
}
