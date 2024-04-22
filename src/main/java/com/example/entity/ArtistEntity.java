package com.example.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "artist")
@Data
public class ArtistEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "artist_name")
    private String artistName;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<SongEntity> songs;
}
