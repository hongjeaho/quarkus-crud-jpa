package com.quarkus.entity;

import java.util.Optional;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long seq;

  private String email;
  private String password;
  private String name;
  private Integer age;

  public UserEntity updateColumn(UserEntity userEntity) {
    this.password = Optional.ofNullable(userEntity.getPassword())
        .orElseGet(this::getPassword);
    this.name = Optional.ofNullable(userEntity.getName())
        .orElseGet(this::getName);
    this.age = Optional.ofNullable(userEntity.getAge())
        .orElseGet(this::getAge);

    return this;
  }
}
