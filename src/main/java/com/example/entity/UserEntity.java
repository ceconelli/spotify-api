package com.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "users")
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @NotNull
    @Email
    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "password")
    private String password;

    @NotNull
    @Column(name = "first_name")
    private String firstname ;

    @Column(name = "last_name")
    private String lastname ;

    @OneToMany(
            mappedBy = "user" ,
            cascade = {CascadeType.PERSIST , CascadeType.MERGE} ,
            orphanRemoval = true
    )
    private List<PlaylistEntity> playlists;
}
