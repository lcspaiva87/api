package com.School_Registration.api.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private IStudentRepository studentRepository;

    @PostMapping("/")
    public ResponseEntity create(@RequestBody StudentModel studentModel) {
        var student = this.studentRepository.findByMatricula(studentModel.getMatricula());

        if(student != null) {
            return ResponseEntity.status(400).body("Matrícula já existe");
        }

        var studentCreated = this.studentRepository.save(studentModel);
        return ResponseEntity.status(201).body(studentCreated);
    }
}
