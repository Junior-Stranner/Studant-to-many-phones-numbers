package com.br.projetoconexao.Componntes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.br.projetoconexao.Model.Papel;
import com.br.projetoconexao.Model.Telefone;
import com.br.projetoconexao.Repository.PapelRepository;
import com.br.projetoconexao.Repository.TelefoneRepository;

@Component
public class CarregaDados implements CommandLineRunner {

    @Autowired
    PapelRepository pRepository;

    @Autowired
    TelefoneRepository tRepository;

    @Override
    public void run(String... args) throws Exception {
        String[] papeis = { "ADMIN", "NORMAL", "CONSULTA" };

        for (String papelString : papeis) {
            Papel papel = pRepository.findByNome(papelString);
            if (papel == null) {
                papel = new Papel(papelString);
                pRepository.save(papel);
            }
        }

}
}
