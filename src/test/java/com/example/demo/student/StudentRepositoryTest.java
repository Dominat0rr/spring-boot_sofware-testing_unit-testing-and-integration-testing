package com.example.demo.student;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class StudentRepositoryTest {

    @Autowired
    StudentRepository repository;

    @AfterEach
    void tearDown() {
        repository.deleteAll();
    }

    @Test
    void itShouldCheckIfStudentExistsByEmail() {
        // given
        Student student = new Student(
                "Dominik",
                "dominik@mail.be",
                Gender.MALE
        );
        repository.save(student);

        // when
        boolean exists = repository.selectExistsEmail(student.getEmail());

        // then
        assertThat(exists).isTrue();
    }

    @Test
    void itShouldCheckIfStudentDoesNotExistsByEmail() {
        // given
        String email = "abc@mail.com";

        // when
        boolean exists = repository.selectExistsEmail(email);

        // then
        assertThat(exists).isFalse();
    }
}
