package com.example.demo.student;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StudentRepositoryTest {

    @Autowired
    StudentRepository repository;

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
}
