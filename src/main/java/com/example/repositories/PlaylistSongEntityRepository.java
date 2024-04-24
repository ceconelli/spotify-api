package com.example.repositories;

import com.example.domain.PlaylistEntity;
import com.example.domain.PlaylistSongEntity;
import com.example.domain.PlaylistSongId;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface PlaylistSongEntityRepository extends JpaRepository<PlaylistSongEntity, PlaylistSongId> {

}
