package com.School_Registration.api.Teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    @Autowired
    private ITeacherRepository teacherRepository;

    @PostMapping("/")
    public ResponseEntity create(@RequestBody TeacherModel teacherModel) {
        var teacher = this.teacherRepository.findByEmail(teacherModel.getEmail());

        if(teacher != null) {
            return ResponseEntity.status(400).body("Email already exists");
        }

        var teacherCreated = this.teacherRepository.save(teacherModel);
        return ResponseEntity.status(201).body(teacherCreated);
    }
} 