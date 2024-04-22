package com.example.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Embeddable
public class PlaylistSongPK implements Serializable {

    @Column(name = "playlist_id")
    private Long playlistId;

    @Column(name = "song_id")
    private Long songId;

}
