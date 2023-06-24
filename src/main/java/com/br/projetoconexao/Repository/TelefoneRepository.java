package com.br.projetoconexao.Repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.projetoconexao.Model.Telefone;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone,Integer> {

    Telefone findByNumero(String teleString);


}

