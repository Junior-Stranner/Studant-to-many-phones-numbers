package com.br.projetoConexao1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.projetoConexao1.Model.Telefone;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Integer> {
    Telefone findByNumero(String numero);

}
