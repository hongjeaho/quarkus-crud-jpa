package com.quarkus.repository;

import com.quarkus.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

  UserEntity findAllByEmail(final String email);
}
