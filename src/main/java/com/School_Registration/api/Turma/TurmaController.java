package com.School_Registration.api.Turma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/turmas")
public class TurmaController {
  @Autowired
  private ITurmaRepository turmaRepository;

  @PostMapping
  public ResponseEntity<?> create(@RequestBody TurmaModel turma) {
    try {
      var turmaCreated = this.turmaRepository.save(turma);
      return ResponseEntity.status(201).body(turmaCreated);
    } catch (Exception e) {
      return ResponseEntity.status(400)
          .body("Erro ao criar turma: " + e.getMessage());
    }
  }

  @GetMapping
  public ResponseEntity<?> list() {
    var turmas = this.turmaRepository.findAll();
    return ResponseEntity.ok(turmas);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> get(@PathVariable Long id) {
    var turma = this.turmaRepository.findById(id);
    if (turma.isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(turma.get());
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> update(@PathVariable Long id, @RequestBody TurmaModel turma) {
    try {
      var existingTurma = this.turmaRepository.findById(id);
      if (existingTurma.isEmpty()) {
        return ResponseEntity.notFound().build();
      }
      turma.setId(id);
      return ResponseEntity.ok(this.turmaRepository.save(turma));
    } catch (Exception e) {
      return ResponseEntity.status(400)
          .body("Erro ao atualizar turma: " + e.getMessage());
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable Long id) {
    var existingTurma = this.turmaRepository.findById(id);
    if (existingTurma.isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    this.turmaRepository.deleteById(id);
    return ResponseEntity.noContent().build();
  }

  // Endpoints adicionais para gerenciar alunos e disciplinas
  @PostMapping("/{id}/alunos/{alunoId}")
  public ResponseEntity<?> addAluno(@PathVariable Long id, @PathVariable Long alunoId) {
    try {
      var turma = this.turmaRepository.findById(id).orElse(null);
      if (turma == null) {
        return ResponseEntity.notFound().build();
      }

      // Lógica para adicionar aluno
      // Nota: Você precisará injetar o AlunoRepository para implementar isso

      return ResponseEntity.ok().build();
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Erro ao adicionar aluno: " + e.getMessage());
    }
  }

  @PostMapping("/{id}/disciplinas/{disciplinaId}")
  public ResponseEntity<?> addDisciplina(@PathVariable Long id, @PathVariable Long disciplinaId) {
    try {
      var turma = this.turmaRepository.findById(id).orElse(null);
      if (turma == null) {
        return ResponseEntity.notFound().build();
      }

      // Lógica para adicionar disciplina
      // Nota: Você precisará injetar o DisciplinaRepository para implementar isso

      return ResponseEntity.ok().build();
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Erro ao adicionar disciplina: " + e.getMessage());
    }
  }
}