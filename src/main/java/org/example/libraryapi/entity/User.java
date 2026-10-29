package org.example.libraryapi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.example.libraryapi.enums.UserRole;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank @Size(max = 50)
    private String firstName, lastName;
    @NotBlank @Email @Column(unique = true, nullable = false)
    private String email;
    @Pattern(
            regexp = "^\\+905\\d{9}$",
            message = "Phone number must be +905xxxxxxxxx"
    )
    private String phoneNumber;
    private String password;
    @Enumerated(value = EnumType.STRING)
    private UserRole role = UserRole.READER;
    private int tokenVersion = 0;
    private Instant deletedAt = null;
}
