package com.School_Registration.api.Class;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.School_Registration.api.Class.ClassModel;

@RestController
@RequestMapping("/classes")
public class ClassController {
  @Autowired
  private IClassRepository classRepository;

  @PostMapping("/")
  public ResponseEntity create(@RequestBody ClassModel classModel) {
    var existingClass = this.classRepository.findByNameAndYear(
        classModel.getName(),
        classModel.getYear());

    if (existingClass != null) {
      return ResponseEntity.status(400)
          .body("Class already exists for this year");
    }

    var classCreated = this.classRepository.save(classModel);
    return ResponseEntity.status(201).body(classCreated);
  }
}