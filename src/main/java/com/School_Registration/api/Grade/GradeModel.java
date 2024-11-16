package com.School_Registration.api.Grade;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.School_Registration.api.Student.StudentModel;
import com.School_Registration.api.Subject.SubjectModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "tb_grades")
public class GradeModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "student_id")
  private StudentModel student;

  @ManyToOne
  @JoinColumn(name = "subject_id")
  private SubjectModel subject;

  private double value;
  private LocalDate evaluationDate;

  @CreationTimestamp
  private LocalDateTime createdAt;
}