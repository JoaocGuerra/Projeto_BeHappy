package br.edu.ifpb.telas;

import br.edu.ifpb.dominio.Aluno;
import br.edu.ifpb.ObterValor;
import br.edu.ifpb.dominio.Avaliacao;
import br.edu.ifpb.dominio.Responsavel;
import br.edu.ifpb.dominio.TemRepresentacaoTextual;
import br.edu.ifpb.padroes.Iterator.ListAvaliacoes;
import br.edu.ifpb.padroes.Strategy.selecionarMenuStrategy;

public class TelaAluno extends ObterValor implements selecionarMenuStrategy {

    private Aluno aluno;
    private Responsavel responsavel_Aluno;

    public TelaAluno(Aluno aluno, Responsavel responsavel) {
        this.aluno = aluno;
        this.responsavel_Aluno =  responsavel;
    }

    public boolean setStrategyMenu() {
        int opcao = 0;
        String menu = "";
        menu += LS + "====================================" + LS;
        menu += "=========== Tela do Aluno ==========" + LS;
        menu += "====================================" + LS;
        menu += ++opcao + ". Avaliar dia" + LS;
        menu += ++opcao + ". Minhas Avaliações" + LS;
        menu += ++opcao + ". Sair" + LS;

        while (true) {
            System.out.println(menu);
            int opcaoEscolhida = obterOpcaoEscolhida("Digite uma opção: ");
            switch (opcaoEscolhida) {
                case 1:
                    if (aluno.fez_Aval()) {
                        System.out.println();
                        System.out.println("Já foi feita a Avaliação!");
                        System.out.println();
                    } else {
                        selecionarMenuStrategy av = new TelaAvaliarDia(this.aluno, this.responsavel_Aluno);
                        av.setStrategyMenu();
                    }
                    break;
                case 2:
                    if (!aluno.fez_Aval()) {
                        System.out.println();
                        System.out.println("Nenhuma avaliação feita.");
                        System.out.println();
                    } else System.out.println(LS +"#### Minhas Avaliações ####");

                    ListAvaliacoes listAvaliacoes = new ListAvaliacoes(aluno.getAvaliacoes());

                    while (listAvaliacoes.hasNext()){
                        Avaliacao avaliacao = (Avaliacao) listAvaliacoes.next();
                        imprimir(avaliacao);
                    }

//                    for (Avaliacao avaliacao : aluno.getAvaliacoes()) {
//                        imprimir(avaliacao);
//                    }
                    break;
                case 3:
                    // sair da tela_Aluno
                    return false;
                default:
                    System.out.println();
                    System.out.println("Erro! Opção desconhecida: " + opcaoEscolhida);
                    System.out.println();
                    break;
            }
        }
    }
}
