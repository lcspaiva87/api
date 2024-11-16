package com.School_Registration.api.Turma;

import com.School_Registration.api.Student.StudentModel;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "turmas", uniqueConstraints = {
    @UniqueConstraint(columnNames = { "nome", "ano" })
})
public class TurmaModel<DisciplineModel> {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(nullable = false)
  private String nome;

  @Column(nullable = false)
  private int ano;

  @ManyToMany
  @JoinTable(name = "turma_alunos", joinColumns = @JoinColumn(name = "turma_id"), inverseJoinColumns = @JoinColumn(name = "aluno_id"))
  private List<StudentModel> students;

  @ManyToMany
  @JoinTable(name = "turma_disciplinas", joinColumns = @JoinColumn(name = "turma_id"), inverseJoinColumns = @JoinColumn(name = "disciplina_id"))
  private List<DisciplineModel> disciplines;
}
