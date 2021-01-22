package com.quarkus.service;

import com.quarkus.entity.UserEntity;
import com.quarkus.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  public UserEntity findByseq(final Long seq){
    return userRepository.findById(seq)
        .orElseGet(UserEntity::new);
  }

  public UserEntity findByEmail(final String email) {
    return userRepository.findAllByEmail(email)
        .orElseThrow(IllegalAccessError::new);
  }

  public UserEntity update(final UserEntity user) {
    return userRepository.findAllByEmail(user.getEmail())
        .map(userEntity -> {
          userEntity.updateColumn(user);
          return userRepository.save(userEntity);
        }).orElseThrow(IllegalAccessError::new);
  }
}
