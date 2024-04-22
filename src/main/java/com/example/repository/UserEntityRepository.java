package com.example.repository;

import com.example.entity.UserEntity;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;
import java.util.Optional;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findById(Long id);
}
