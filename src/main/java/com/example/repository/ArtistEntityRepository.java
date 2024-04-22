package com.example.repository;

import com.example.entity.ArtistEntity;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface ArtistEntityRepository extends JpaRepository<ArtistEntity, Long> {
    Optional<ArtistEntity> findById(Long id);
}
