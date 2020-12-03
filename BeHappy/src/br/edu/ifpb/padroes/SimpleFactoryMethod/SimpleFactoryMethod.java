package br.edu.ifpb.padroes.SimpleFactoryMethod;

import br.edu.ifpb.dominio.Aluno;
import br.edu.ifpb.dominio.Responsavel;

public class SimpleFactoryMethod implements Interface_SimpleFactoryMethod {

    public Aluno gerarAluno(){
        return new Aluno();
    }

    public Responsavel gerarResponsavel(){
        return new Responsavel();
    }

}
