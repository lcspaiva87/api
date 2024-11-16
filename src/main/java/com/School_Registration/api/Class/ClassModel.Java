package com.School_Registration.api.Class;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.School_Registration.api.Student.StudentModel;
import com.School_Registration.api.Subject.SubjectModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity(name = "tb_classes")
public class ClassModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private int year;
    
    @OneToMany(mappedBy = "class")
    private List<StudentModel> students;
    
    @ManyToMany
    @JoinTable(
        name = "tb_class_subjects",
        joinColumns = @JoinColumn(name = "class_id"),
        inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private List<SubjectModel> subjects;

    @CreationTimestamp
    private LocalDateTime createdAt;
}