package com.example.repository;

import com.example.entity.PlaylistEntity;
import com.example.entity.PlaylistSongEntity;
import com.example.entity.PlaylistSongPK;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface PlaylistSongEntityRepository extends JpaRepository<PlaylistSongEntity, PlaylistSongPK> {

}
