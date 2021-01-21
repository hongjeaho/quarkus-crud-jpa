package com.quarkus.repository;

import com.quarkus.entity.UserEntity;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

  Optional<UserEntity> findAllByEmail(final String email);
}
