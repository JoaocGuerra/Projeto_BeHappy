package br.edu.ifpb.padroes.SimpleFactoryMethod;

import br.edu.ifpb.dominio.Aluno;
import br.edu.ifpb.dominio.Responsavel;

public interface Interface_SimpleFactoryMethod {
    Aluno gerarAluno();
    Responsavel gerarResponsavel();
}