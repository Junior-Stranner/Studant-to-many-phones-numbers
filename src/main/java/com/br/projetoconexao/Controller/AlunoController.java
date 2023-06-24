package com.br.projetoconexao.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.br.projetoconexao.Model.Aluno;
import com.br.projetoconexao.Model.Papel;
import com.br.projetoconexao.Model.Telefone;
import com.br.projetoconexao.Repository.AlunoRepository;
import com.br.projetoconexao.Repository.PapelRepository;
import com.br.projetoconexao.Repository.TelefoneRepository;

@Controller
public class AlunoController {

    @Autowired
    AlunoRepository repository;

    @Autowired
    TelefoneRepository tRepository;

    @Autowired
    PapelRepository pRepository;

    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("home");
        ArrayList<Papel> papeis = new ArrayList<>();
        ArrayList<Telefone> telefones = new ArrayList<>();
        papeis = (ArrayList<Papel>) pRepository.findAll();
        telefones = (ArrayList<Telefone>) tRepository.findAll();
        mv.addObject("papeis", papeis);
        mv.addObject("telefones", telefones);
        return mv;
    }

    @PostMapping("/home")
    public String salvar(Aluno aluno ,@RequestParam("pps") List<Integer> papelId, @RequestParam("id") Integer telefoneId) {
        ArrayList<Papel> papeis = new ArrayList<>();
    for (Integer id : papelId) {
      papeis.add(pRepository.findById(id).get());
  }

        Telefone fone = new Telefone(null);
        fone = tRepository.findById(telefoneId).get();
        fone.setAluno(aluno);
        tRepository.save(fone);

        return "redirect:/list";
    }

    @GetMapping("/list")
    public ModelAndView lista() {
        ModelAndView mv = new ModelAndView("list");
        ArrayList<Aluno> alunos = new ArrayList<>();
        alunos = (ArrayList<Aluno>) repository.findAll();
        mv.addObject("alunos", alunos);
        return mv;
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") int id) {
        repository.deleteById(id);
        return "redirect:/list";

    }

    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable("id") int id) {
        ModelAndView mv = new ModelAndView("home");
        Aluno aluno = new Aluno();
        aluno = repository.findById(id).get();
        mv.addObject("aluno", aluno);

        return mv;

    }

}
