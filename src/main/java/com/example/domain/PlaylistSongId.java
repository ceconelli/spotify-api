package com.example.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@ToString
@Embeddable
public class PlaylistSongId implements Serializable {

    @Column(name = "playlist_id")
    private Long playlistId;

    @Column(name = "song_id")
    private Long songId;

    public PlaylistSongId(Long playlistId, Long songId) {
        this.playlistId = playlistId;
        this.songId = songId;
    }

    public PlaylistSongId() {

    }
}
