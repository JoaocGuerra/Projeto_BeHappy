package br.edu.ifpb.dominio;

import br.edu.ifpb.ObterValor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class Responsavel extends ObterValor implements TemRepresentacaoTextual, Serializable {
    private String nome;
    private String email;
    private Long cpf;
    private Collection<Aluno> alunos_do_Responsavel;

    public Responsavel() {
        this.alunos_do_Responsavel = new ArrayList<Aluno>();
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public Long getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public Collection<Aluno> getAlunos_do_Responsavel() {
        return alunos_do_Responsavel;
    }

    public void setAlunos_do_Responsavel(Collection<Aluno> alunos_do_Responsavel) {
        this.alunos_do_Responsavel = alunos_do_Responsavel;
    }

    public void add_Aluno_Responsavel(Aluno aluno) {
        this.alunos_do_Responsavel.add(aluno);
    }

    @Override
    public String obterRepresentacaoTextual() {
        String texto = "";
        texto += LS + "Rsponsável: " + getNome() +
                LS + "Email: " + getEmail() +
                LS + "CPF: " + getCpf();
        return texto;
    }
}