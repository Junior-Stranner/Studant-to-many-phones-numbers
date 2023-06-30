package com.br.projetoConexao1.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String numero;

    @ManyToOne(cascade = CascadeType.ALL)
    private Aluno aluno;

    public int getId() {
        return id;
    }

    public Telefone() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public Telefone(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

}
