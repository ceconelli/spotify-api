package com.example.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Entity
@Table(name = "songs")
@Getter
@Setter
@ToString
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

    @OneToMany(mappedBy = "song")
    @ToString.Exclude
    private Set<PlaylistSongEntity> playlists;

    @ManyToOne
    private ArtistEntity artist;


}
