package com.example.repositories;

import com.example.domain.SongEntity;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface SongEntityRepository extends JpaRepository<SongEntity, Long> {
    Optional<SongEntity> findById(Long id);
}
