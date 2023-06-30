package com.br.projetoConexao1.Compenentes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.br.projetoConexao1.Model.Papel;
import com.br.projetoConexao1.Model.Telefone;
import com.br.projetoConexao1.Repository.PapelRepository;
import com.br.projetoConexao1.Repository.TelefoneRepository;

@Component
public class CarregaDados implements CommandLineRunner {

    @Autowired
    PapelRepository pRepository;

    @Autowired
    TelefoneRepository telRepository;

    @Override
    public void run(String... args) throws Exception {
        String[] papeis = { "ADMIN", "NORMAL", "CONSULTA" };

        for (String papelString : papeis) {
            Papel papel = pRepository.findByNome(papelString);
            if (papel == null) {
                papel = new Papel(papelString);
                pRepository.save(papel);
            }

            String[] telefones = { "9898989 (Celular)", "3423334 (Residencial)" };

            for (String numeroTel : telefones) {
                Telefone telefone = telRepository.findByNumero(numeroTel);
                if (telefone == null) {
                    telefone = new Telefone(numeroTel);
                    telRepository.save(telefone);
                }
            }
        }
    }
}
