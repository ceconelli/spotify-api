package com.example.entity;

import jakarta.persistence.*;
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

    @Column
    private String title;

    @Column
    private String artist;

    @Column
    private String album;

    @Column
    private int year;

    @Column
    private String genre;

    @Column
    private int durationInSeconds;

    @ManyToMany(mappedBy = "songs")
    private Set<PlaylistEntity> playlists;


}
