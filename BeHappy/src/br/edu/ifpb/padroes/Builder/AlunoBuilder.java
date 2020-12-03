package br.edu.ifpb.padroes.Builder;

import br.edu.ifpb.dominio.Aluno;
import br.edu.ifpb.padroes.SimpleFactoryMethod.SimpleFactoryMethod;
import br.edu.ifpb.padroes.SimpleFactoryMethod.Interface_SimpleFactoryMethod;

public class AlunoBuilder {
    private Long matricula;
    private String nome;
    private int idade;
    private Long cpf_responsavel;

    public AlunoBuilder comMatricula(Long matricula) {
        this.matricula = matricula;
        return this;
    }

    public AlunoBuilder comNome(String nome) {
        this.nome = nome;
        return this;
    }

    public AlunoBuilder deIdade(int idade) {
        this.idade = idade;
        return this;
    }

    public AlunoBuilder comCpf_responsavel(Long cpf_responsavel) {
        this.cpf_responsavel = cpf_responsavel;
        return this;
    }

    public Aluno Builder() {
        Interface_SimpleFactoryMethod simpleFactoryMethod = new SimpleFactoryMethod();
        Aluno aluno = simpleFactoryMethod.gerarAluno();
        aluno.setMatricula(matricula);
        aluno.setNome(nome);
        aluno.setIdade(idade);
        aluno.setCpf_responsavel(cpf_responsavel);
        return aluno;
    }
}
