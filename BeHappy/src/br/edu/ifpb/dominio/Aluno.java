package br.edu.ifpb.dominio;

import br.edu.ifpb.ObterValor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class Aluno extends ObterValor implements TemRepresentacaoTextual, Serializable {
    private Long matricula;
    private String nome;
    private int idade;
    private Long cpf_responsavel;
    private Collection<Avaliacao> avaliacoes;


    public Aluno() {
        this.avaliacoes = new ArrayList<Avaliacao>();
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Long getCpf_responsavel() {
        return cpf_responsavel;
    }

    public void setCpf_responsavel(Long cpf_responsavel) {
        this.cpf_responsavel = cpf_responsavel;
    }

    public Boolean fez_Aval(){
        if (!avaliacoes.isEmpty()) {
            for (Avaliacao avaliacao : avaliacoes) {
                if (avaliacao.getData_av().equals(LocalDate.now())) {
                    return true;
                }
            }
        }
        return false;
    }


    public Collection<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(Collection<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public void add_Avaliacao(Avaliacao avaliacao){
        this.avaliacoes.add(avaliacao);
    }

    @Override
    public String obterRepresentacaoTextual() {
        String texto = "";
        texto += LS + "Aluno: " + getNome()
                + LS + "Matrícula: " + getMatricula()
                + LS + "Idade:" + getIdade()
                + LS + "Cpf do Responsável: " + getCpf_responsavel();

        return texto;
    }
}