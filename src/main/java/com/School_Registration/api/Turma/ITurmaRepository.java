package com.School_Registration.api.Turma;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ITurmaRepository extends JpaRepository<TurmaModel, Long> {
  TurmaModel findByNomeAndAno(String nome, int ano);

  List<TurmaModel> findByAno(int ano);

  List<TurmaModel> findByNomeContaining(String nome);
}