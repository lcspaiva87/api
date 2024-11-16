package com.School_Registration.api.Discipline;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.School_Registration.api.Teacher.TeacherModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "tb_disciplines")
public class DisciplineModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private int workload; // carga horária
    
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private TeacherModel teacher;

    @CreationTimestamp
    private LocalDateTime createdAt;
}