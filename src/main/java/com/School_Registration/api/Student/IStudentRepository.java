package com.School_Registration.api.Student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<StudentModel, Long> {
    StudentModel findByMatricula(String matricula);
}
