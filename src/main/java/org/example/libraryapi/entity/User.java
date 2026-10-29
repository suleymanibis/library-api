package org.example.libraryapi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.example.libraryapi.enums.UserRole;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;

@Entity
@Table(name = "users")
public class User {
    @Id @GeneratedValue()
    private Long id;
    @NotBlank @Size(max = 50)
    private String firstname, lastname;
    @NotBlank @Email @Column(unique = true)
    private String email;
    private String password;
    @Enumerated(value = EnumType.STRING)
    private UserRole role = UserRole.READER;
    private int tokenVersion = 0;
    @LastModifiedDate
    private Instant deletedAt = null;
}
