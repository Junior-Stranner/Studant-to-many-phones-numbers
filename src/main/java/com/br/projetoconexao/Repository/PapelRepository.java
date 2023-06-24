package com.br.projetoconexao.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.projetoconexao.Model.Papel;
import com.br.projetoconexao.Model.Telefone;

public interface PapelRepository extends JpaRepository<Papel, Integer> {
    Papel findByNome(String nome);

    void save(Telefone telefone);
}
