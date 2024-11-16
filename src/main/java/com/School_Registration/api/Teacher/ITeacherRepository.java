package com.School_Registration.api.Teacher;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ITeacherRepository extends JpaRepository<TeacherModel, Long> {
    TeacherModel findByEmail(String email);
} 