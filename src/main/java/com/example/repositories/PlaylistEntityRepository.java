package com.example.repositories;

import com.example.domain.PlaylistEntity;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface PlaylistEntityRepository extends JpaRepository<PlaylistEntity, Long> {
    Optional<PlaylistEntity> findById(Long id);
}
