package com.School_Registration.api.Grade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/grades")
public class GradeController {
  @Autowired
  private IGradeRepository gradeRepository;

  @PostMapping("/")
  public ResponseEntity create(@RequestBody GradeModel gradeModel) {
    // Validação do valor da nota
    if (gradeModel.getValue() < 0 || gradeModel.getValue() > 10) {
      return ResponseEntity.status(400)
          .body("Grade value must be between 0 and 10");
    }

    // Verifica se já existe nota para este aluno nesta disciplina na mesma data
    var existingGrade = this.gradeRepository
        .findByStudentIdAndSubjectIdAndEvaluationDate(
            gradeModel.getStudent().getId(),
            gradeModel.getSubject().getId(),
            gradeModel.getEvaluationDate());

    if (existingGrade != null) {
      return ResponseEntity.status(400)
          .body("Grade already exists for this student in this subject on this date");
    }

    var gradeCreated = this.gradeRepository.save(gradeModel);
    return ResponseEntity.status(201).body(gradeCreated);
  }
}