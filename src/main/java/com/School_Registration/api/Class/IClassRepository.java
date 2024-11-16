package com.School_Registration.api.Class;

import org.jboss.logging.processor.generator.model.ClassModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClassRepository extends JpaRepository<ClassModel, Long> {
    ClassModel findByNameAndYear(String name, int year);
} 