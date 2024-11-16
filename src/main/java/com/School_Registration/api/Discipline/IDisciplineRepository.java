package com.School_Registration.api.Discipline;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IDisciplineRepository<DisciplineModel> extends JpaRepository<DisciplineModel, Long> {
    DisciplineModel findByName(String name);
}