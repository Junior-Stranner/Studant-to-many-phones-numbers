package com.br.projetoconexao.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.projetoconexao.Model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

}
