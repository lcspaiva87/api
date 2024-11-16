package com.School_Registration.api.Student;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "tb_students")
public class StudentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    
    @Column(unique = true)
    private String matricula;
    
    private String email;
    private LocalDate dataNascimento;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
