package com.br.projetoConexao1.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Papel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String nome;

    @ManyToMany(mappedBy = "papeis", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<Aluno> alunos;

    public Papel() {

    }

    public Papel(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

}
