package com.br.projetoConexao1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.projetoConexao1.Model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

}
