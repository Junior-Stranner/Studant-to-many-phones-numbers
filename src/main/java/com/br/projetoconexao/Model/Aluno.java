package com.br.projetoconexao.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String usuario;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "aluno_papel", joinColumns = @JoinColumn(name = "aluno_id"), inverseJoinColumns = @JoinColumn(name = "papel_id"))
    List<Papel> papeis;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aluno")
    List<Telefone> telefones;

    public Aluno() {

    }

    public Aluno(int id, String nome, String usuario) {
        this.id = id;
        this.nome = nome;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }public List<Telefone> getTelefones() {
    return telefones;
}

public void setTelefones(List<Telefone> telefones) {
    this.telefones = telefones;
}



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public List<Papel> getPapeis() {
        return papeis;
    }

    public void setPapeis(List<Papel> papeis) {
        this.papeis = papeis;
    }
      public List<Telefone> getTelefone() {
        return telefones;
    }

    public void setTelefone(List<Telefone> telefones) {
        this.telefones = telefones;
    }

}
