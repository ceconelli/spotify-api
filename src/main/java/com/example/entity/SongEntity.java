package com.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "songs")
@Data
public class SongEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "title")
    private String title;

    @NotNull
    @Column(name = "album")
    private String album;

    @NotNull
    @Column(name = "year")
    private int year;

    @NotNull
    @Column(name = "genre")
    private String genre;

    @NotNull
    @Column(name = "duration_in_seconds")
    private int durationInSeconds;

    @ManyToMany(mappedBy = "songs")
    private Set<PlaylistEntity> playlists;

    @ManyToOne
    private ArtistEntity artist;


}
