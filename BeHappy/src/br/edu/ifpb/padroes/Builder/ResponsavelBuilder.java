package br.edu.ifpb.padroes.Builder;

import br.edu.ifpb.dominio.Responsavel;
import br.edu.ifpb.padroes.SimpleFactoryMethod.SimpleFactoryMethod;
import br.edu.ifpb.padroes.SimpleFactoryMethod.Interface_SimpleFactoryMethod;

public class ResponsavelBuilder {
    private String nome;
    private String email;
    private Long cpf;

    public ResponsavelBuilder comNome(String nome) {
        this.nome = nome;
        return this;
    }

    public ResponsavelBuilder comEmail(String email) {
        this.email = email;
        return this;
    }

    public ResponsavelBuilder comCpf(Long cpf) {
        this.cpf = cpf;
        return this;
    }

    public Responsavel Builder() {
        Interface_SimpleFactoryMethod simpleFactoryMethod = new SimpleFactoryMethod();

        Responsavel responsavel = simpleFactoryMethod.gerarResponsavel();

        responsavel.setNome(this.nome);
        responsavel.setEmail(this.email);
        responsavel.setCpf(this.cpf);

        return responsavel;
    }
}
