package com.School_Registration.api.Grade;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IGradeRepository extends JpaRepository<GradeModel, Long> {
  GradeModel findByStudentIdAndSubjectIdAndEvaluationDate(
      Long studentId,
      Long subjectId,
      LocalDate evaluationDate);
}