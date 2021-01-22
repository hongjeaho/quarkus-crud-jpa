package com.quarkus.controller;

import com.quarkus.entity.UserEntity;
import com.quarkus.service.UserService;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

  private final UserService userService;

  @GetMapping("/{seq}")
  public ResponseEntity<UserEntity> get(@PathVariable Long seq) {
    return new ResponseEntity<>(userService.findByseq(seq), HttpStatus.OK);
  }

  @PutMapping
  public ResponseEntity<UserEntity> put(@RequestBody UserEntity user) {
    return new ResponseEntity<>(userService.update(user), HttpStatus.OK);
  }
}
