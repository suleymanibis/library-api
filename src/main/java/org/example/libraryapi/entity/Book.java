package org.example.libraryapi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.example.libraryapi.enums.BookStatus;

import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Book {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank @Column(unique = true)
    private String isbn;
    @NotBlank @Size(max = 100)
    private String name;
    @Size(min = 1) @ElementCollection
    private List<@NotBlank @Size(max = 100) String> authors;
    private BookStatus status = BookStatus.ACTIVE;
    @PositiveOrZero
    private int totalCopyAmount = 0;
    @PositiveOrZero
    private int currentCopyAmount;

    public Book(){
        this.currentCopyAmount = this.totalCopyAmount;
    }

    public void setStatusPassive(){
        this.status = BookStatus.PASSIVE;
        this.totalCopyAmount = 0;
        this.currentCopyAmount = 0;
    }

    public void setStatusActive(int newTotalCopyAmount){
        this.status = BookStatus.ACTIVE;
        this.totalCopyAmount = newTotalCopyAmount;
        this.currentCopyAmount = this.totalCopyAmount;
    }
}
