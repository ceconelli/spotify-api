package com.example.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "playlist_song")
@Data
public class PlaylistSongEntity {
    @EmbeddedId
    private PlaylistSongPK id ;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("playlistId")
    private PlaylistEntity playlistEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("songId")
    private SongEntity songEntity;
}
