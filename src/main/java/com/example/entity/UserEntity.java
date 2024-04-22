package com.example.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "users")
@Data
public class UserEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String username;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String firstname ;

    @Column
    private String lastname ;

    @OneToMany(
            mappedBy = "user" ,
            cascade = {CascadeType.PERSIST , CascadeType.MERGE} ,
            orphanRemoval = true
    )
    private List<PlaylistEntity> playlists;
}
