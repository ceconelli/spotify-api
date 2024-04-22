package com.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "playlists")
@Data
public class PlaylistEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @NotNull
    @Column
    private String name ;

    @Column
    private String description ;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserEntity user ;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
            CascadeType.REFRESH })
    @JoinTable(
            name = "playlist_song",
            joinColumns = {@JoinColumn(name = "playlist_id")} ,
            inverseJoinColumns = {@JoinColumn(name = "song_id")}
    )
    private Set<SongEntity> songs;
}
