package com.example.domain;

import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenerationTime;

import java.time.LocalDateTime;
import java.util.List;

class teset {

}


@Entity
@Table(name = "playlist_song")
@Getter
@Setter
public class PlaylistSongEntity {

    @EmbeddedId
    private PlaylistSongId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("playlistId")
    private PlaylistEntity playlist;

    @Column(name = "songPosition", columnDefinition="serial", insertable=false)
    private Integer songPosition;

    @Column(name = "addedAt")
    private LocalDateTime addedAt = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("songId")
    private SongEntity song;

    public PlaylistSongEntity() {

    }

    public PlaylistSongEntity(PlaylistSongId id, PlaylistEntity playlist, SongEntity song) {
        this.id = id;
        this.playlist = playlist;
        this.song = song;
    }
}
