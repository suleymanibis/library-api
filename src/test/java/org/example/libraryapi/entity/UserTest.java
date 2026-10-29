package org.example.libraryapi.entity;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.example.libraryapi.enums.UserRole;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {
    private Validator validator;

    @BeforeEach
    void setUp(){
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    void validUser_shouldPassValidation(){
        User validUser = User.builder()
                .firstName("john")
                .lastName("care")
                .email("johncare@example.com")
                .phoneNumber("+905121231212")
                .password("123456")
                .build();

        Set<ConstraintViolation<User>> violations = validator.validate(validUser);
        assertTrue(violations.isEmpty());
    }

    @Test
    void blankFirstName_shouldFailValidation(){
        User validUser = User.builder()
                .firstName("")
                .lastName("care")
                .email("johncare@example.com")
                .phoneNumber("+905121231212")
                .password("123456")
                .build();

        Set<ConstraintViolation<User>> violations = validator.validate(validUser);
        assertFalse(violations.isEmpty());
    }

    @Test
    void invalidSizeFirstName_shouldFailValidation(){
        User validUser = User.builder()
                .firstName("fffffffffffffffffffffffffffffffffffffffffffffffffff")
                .lastName("care")
                .email("johncare@example.com")
                .phoneNumber("+905121231212")
                .password("123456")
                .build();

        Set<ConstraintViolation<User>> violations = validator.validate(validUser);
        assertFalse(violations.isEmpty());
    }

    @Test
    void blankLastName_shouldFailValidation(){
        User validUser = User.builder()
                .firstName("john")
                .lastName("")
                .email("johncare@example.com")
                .phoneNumber("+905121231212")
                .password("123456")
                .build();

        Set<ConstraintViolation<User>> violations = validator.validate(validUser);
        assertFalse(violations.isEmpty());
    }

    @Test
    void invalidSizeLastName_shouldFailValidation(){
        User validUser = User.builder()
                .firstName("john")
                .lastName("fffffffffffffffffffffffffffffffffffffffffffffffffff")
                .email("johncare@example.com")
                .phoneNumber("+905121231212")
                .password("123456")
                .build();

        Set<ConstraintViolation<User>> violations = validator.validate(validUser);
        assertFalse(violations.isEmpty());
    }

    @Test
    void blankEmail_shouldFailValidation(){
        User validUser = User.builder()
                .firstName("john")
                .lastName("care")
                .email("")
                .phoneNumber("+905121231212")
                .password("123456")
                .build();

        Set<ConstraintViolation<User>> violations = validator.validate(validUser);
        assertFalse(violations.isEmpty());
    }

    @Test
    void blankPhoneNumber_shouldPassValidation(){
        User validUser = User.builder()
                .firstName("john")
                .lastName("care")
                .email("johncare@example.com")
                .password("123456")
                .build();

        Set<ConstraintViolation<User>> violations = validator.validate(validUser);
        assertTrue(violations.isEmpty());
    }

    @Test
    void invalidPhoneNumber_shouldFailValidation(){
        User validUser = User.builder()
                .firstName("john")
                .lastName("care")
                .email("johncare@example.com")
                .phoneNumber("123")
                .password("123456")
                .build();

        Set<ConstraintViolation<User>> violations = validator.validate(validUser);
        assertFalse(violations.isEmpty());
    }

    @Test
    void blankPassword_shouldFailValidation(){
        User validUser = User.builder()
                .firstName("john")
                .lastName("care")
                .email("johncare@example.com")
                .phoneNumber("+905121231212")
                .password("")
                .build();

        Set<ConstraintViolation<User>> violations = validator.validate(validUser);
        assertFalse(violations.isEmpty());
    }
}
