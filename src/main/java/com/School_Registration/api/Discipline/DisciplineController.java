package com.School_Registration.api.Discipline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/disciplines")
public class DisciplineController<DisciplineModel> {
    @Autowired
    private IDisciplineRepository disciplineRepository;

    @PostMapping
    public ResponseEntity create(@RequestBody DisciplineModel disciplineModel) {
        var discipline = this.disciplineRepository.findByName(disciplineModel.toString());

        if(discipline != null) {
            return ResponseEntity.status(400).body("Discipline already exists");
        }

        var disciplineCreated = this.disciplineRepository.save(disciplineModel);
        return ResponseEntity.status(201).body(disciplineCreated);
    }
}