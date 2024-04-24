package com.example.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "artists")
@Getter
@Setter
@ToString
public class ArtistEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "artist_name")
    private String artistName;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<SongEntity> songs;
}
