package br.com.medsync.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "user")
@Table(name = "user_db")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "username", length = 20, updatable = true, nullable = false)
    private String username;

    @Column(name = "name", length = 50, updatable = true, nullable = false)
    private String name;

    @Column(name = "email", length = 70, updatable = true, nullable = false)
    private String email;

    @Column(name = "password", length = 50, updatable = true, nullable = false)
    private String password;
}
