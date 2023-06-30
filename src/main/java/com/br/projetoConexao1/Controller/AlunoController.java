package com.br.projetoConexao1.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.br.projetoConexao1.Model.Aluno;
import com.br.projetoConexao1.Model.Papel;
import com.br.projetoConexao1.Model.Telefone;
import com.br.projetoConexao1.Repository.AlunoRepository;
import com.br.projetoConexao1.Repository.PapelRepository;
import com.br.projetoConexao1.Repository.TelefoneRepository;

@Controller
public class AlunoController {

    @Autowired
    AlunoRepository aRepository;

    @Autowired
    PapelRepository pRepository;

    @Autowired
    TelefoneRepository telRepository;

    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("home");
        ArrayList<Papel> papeis = new ArrayList<>();
        papeis = (ArrayList<Papel>) pRepository.findAll();
        mv.addObject("papeis", papeis);

        ArrayList<Telefone> telefones = new ArrayList<>();
        telefones = (ArrayList<Telefone>) telRepository.findAll();
        mv.addObject("telefones", telefones);
        return mv;
    }

    @PostMapping("/home")
    public String cadastrarUsuario(Aluno aluno, @RequestParam("pps") List<Integer> papelId,
            @RequestParam("tel") Integer telefone) {
        ArrayList<Papel> papeis = new ArrayList<>();
        for (Integer id : papelId) {
            papeis.add(pRepository.findById(id).get());
        }
        aluno.setPapeis(papeis);
        aRepository.save(aluno);

        Telefone fone = new Telefone();
        fone = telRepository.findById(telefone).get();
        fone.setAluno(aluno);
        telRepository.save(fone);
        return "redirect:/list";

    }

    @GetMapping("/list")
    public ModelAndView lista() {
        ModelAndView mv = new ModelAndView("list");
        ArrayList<Aluno> alunos = new ArrayList<>();
        alunos = (ArrayList<Aluno>) aRepository.findAll();
        mv.addObject("alunos", alunos);
        return mv;
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") int id) {
        aRepository.deleteById(id);
        return "redirect:/list";

    }

    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable("id") int id) {
        ModelAndView mv = new ModelAndView("home");
        Aluno aluno = new Aluno();
        aluno = aRepository.findById(id).get();
        mv.addObject("aluno", aluno);

        return mv;

    }

}
