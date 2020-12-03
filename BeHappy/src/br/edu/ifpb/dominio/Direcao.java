package br.edu.ifpb.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class Direcao implements Serializable {
    private int pass;
    private Collection<Responsavel> responsaveis;
    private Collection<Aluno> alunos;

    public Direcao(int pass) {
        this.responsaveis = new ArrayList<Responsavel>();
        this.alunos = new ArrayList<Aluno>();
        this.pass = pass;
    }

    public int getPass() {
        return pass;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }

    public Collection<Responsavel> getResponsaveis() {
        return responsaveis;
    }

    public void setResponsaveis(Collection<Responsavel> responsaveis) {
        this.responsaveis = responsaveis;
    }

    public Collection<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(Collection<Aluno> alunos) {
        this.alunos = alunos;
    }

    public void add_Aluno(Aluno aluno){
        alunos.add(aluno);

    }
    public void add_Responsavel(Responsavel responsavel){
        responsaveis.add(responsavel);
    }
}