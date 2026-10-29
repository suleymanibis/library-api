package org.example.libraryapi.entity;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookTest {
    private Validator validator;

    @BeforeEach
    void setUp(){
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    void validBook_shouldPassValidation(){
        Book validBook = Book.builder()
                .isbn("123456A")
                .name("Sapiens")
                .authors(List.of("Yoval Noah Hariri"))
                .totalCopyAmount(10)
                .build();


        Set<ConstraintViolation<Book>> violations = validator.validate(validBook);
        assertTrue(violations.isEmpty());
    }

    @Test
    void blankIsbnBook_shouldFailValidation(){
        Book validBook = Book.builder()
                .isbn("")
                .name("Sapiens")
                .authors(List.of("Yoval Noah Hariri"))
                .totalCopyAmount(10)
                .build();


        Set<ConstraintViolation<Book>> violations = validator.validate(validBook);
        assertFalse(violations.isEmpty());
    }

    @Test
    void blankNameBook_shouldFailValidation(){
        Book validBook = Book.builder()
                .isbn("123456A")
                .name("")
                .authors(List.of("Yoval Noah Hariri"))
                .totalCopyAmount(10)
                .build();


        Set<ConstraintViolation<Book>> violations = validator.validate(validBook);
        assertFalse(violations.isEmpty());
    }

    @Test
    void invalidSizeNameBook_shouldFailValidation(){
        Book validBook = Book.builder()
                .isbn("123456A")
                .name("fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff")
                .authors(List.of("Yoval Noah Hariri"))
                .totalCopyAmount(10)
                .build();


        Set<ConstraintViolation<Book>> violations = validator.validate(validBook);
        assertFalse(violations.isEmpty());
    }

    @Test
    void invalidSizeElementAuthorsListBook_shouldFailValidation(){
        Book validBook = Book.builder()
                .isbn("123456A")
                .name("Sapiens")
                .authors(List.of("fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff"))
                .totalCopyAmount(10)
                .build();


        Set<ConstraintViolation<Book>> violations = validator.validate(validBook);
        assertFalse(violations.isEmpty());
    }

    @Test
    void blankElementAuthorsListBook_shouldFailValidation(){
        Book validBook = Book.builder()
                .isbn("123456A")
                .name("Sapiens")
                .authors(List.of(""))
                .totalCopyAmount(10)
                .build();


        Set<ConstraintViolation<Book>> violations = validator.validate(validBook);
        assertFalse(violations.isEmpty());
    }

    @Test
    void blankAuthorsListBook_shouldFailValidation(){
        Book validBook = Book.builder()
                .isbn("123456A")
                .name("Sapiens")
                .authors(List.of())
                .totalCopyAmount(10)
                .build();


        Set<ConstraintViolation<Book>> violations = validator.validate(validBook);
        assertFalse(violations.isEmpty());
    }

    @Test
    void invalidTotalCopyAmountBook_shouldFailValidation(){
        Book validBook = Book.builder()
                .isbn("123456A")
                .name("Sapiens")
                .authors(List.of("Yoval Noah Hariri"))
                .totalCopyAmount(-1)
                .build();


        Set<ConstraintViolation<Book>> violations = validator.validate(validBook);
        assertFalse(violations.isEmpty());
    }
}
