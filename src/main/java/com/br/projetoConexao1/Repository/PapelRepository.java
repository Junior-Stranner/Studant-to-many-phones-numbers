package com.br.projetoConexao1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.projetoConexao1.Model.Papel;

@Repository
public interface PapelRepository extends JpaRepository<Papel, Integer> {
    Papel findByNome(String nome);
}
