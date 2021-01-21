package com.quarkus.service;

import com.quarkus.entity.UserEntity;
import com.quarkus.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  public UserEntity findByEmail(final String email) {
    return userRepository.findAllByEmail(email);
  }
}
