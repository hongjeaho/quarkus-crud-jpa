package com.quarkus.repository;

import com.quarkus.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

  UserEntity findAllByEmail(final String email);
}
