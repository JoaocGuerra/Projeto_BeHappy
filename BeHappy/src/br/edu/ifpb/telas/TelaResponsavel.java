package br.edu.ifpb.telas;

import br.edu.ifpb.dominio.Aluno;
import br.edu.ifpb.dominio.Avaliacao;
import br.edu.ifpb.dominio.Responsavel;
import br.edu.ifpb.ObterValor;
import br.edu.ifpb.padroes.Strategy.selecionarMenuStrategy;

import java.sql.SQLOutput;
import java.util.Collection;

public class TelaResponsavel extends ObterValor implements selecionarMenuStrategy {
    private Responsavel responsavel;

    public TelaResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }

    public boolean setStrategyMenu() {
        int opcao = 0;
        String menu = "";
        String menu2 = "";
        menu += LS + "====================================" + LS;
        menu += "======== Tela do Responsável =======" + LS;
        menu += "====================================" + LS;
        menu2 += ++opcao + ". Alunos" + LS;
        menu2 += ++opcao + ". Relatório" + LS;
        menu2 += ++opcao + ". Sair" + LS;


        for (Aluno aluno1 : this.responsavel.getAlunos_do_Responsavel()) {
            if (!aluno1.fez_Aval()) {
                menu += aluno1.obterRepresentacaoTextual() + LS + "Não avaliou o dia." + LS;

            }
        }

        while (true) {
            System.out.println(menu);
            System.out.println(menu2);

            int opcaoEscolhida = obterOpcaoEscolhida("Digite uma opção: ");
            switch (opcaoEscolhida) {
                case 1:
                    for (Aluno aluno1 : this.responsavel.getAlunos_do_Responsavel()) {
                        imprimir(aluno1);
                    }
                    break;
                case 2:
                    relatorio();
                    break;
                case 3:
                    // sair da tela_Responsável
                    return false;
                default:
                    System.out.println();
                    System.out.println("Erro! Opção desconhecida: " + opcaoEscolhida);
                    System.out.println();
                    break;
            }
        }
    }

    private void relatorio(){
        int cont_alegre, cont_triste, cont_zangado;
        cont_alegre = 0;
        cont_triste = 0;
        cont_zangado = 0;
        System.out.println("\nRelatório de avaliações: \n");
        for (Aluno aluno: responsavel.getAlunos_do_Responsavel()){
            if(aluno.fez_Aval()){
                int qtd_aval = aluno.getAvaliacoes().size();
                for(Avaliacao avaliacao: aluno.getAvaliacoes()){
                    if(avaliacao.getEmoji().equals("Alegre")) cont_alegre++;
                    else if(avaliacao.getEmoji().equals("Triste")) cont_triste++;
                    else cont_zangado++;
                }
                System.out.println(
                        "Todas as avaliações do aluno: " + aluno.getNome() + LS +
                                "Avaliações alegres: " + cont_alegre + LS +
                                "Avaliações tristes: " + cont_triste + LS +
                                "Avaliações zangadas: " + cont_zangado + LS
                );
                int cont = 0;
                System.out.println("Últimas 3 avaliações do aluno: " + aluno.getNome() + LS);
                for (Avaliacao avaliacao2: aluno.getAvaliacoes()){
                    if (cont == qtd_aval - 2){
                       imprimir(avaliacao2);
                    }else if (cont == qtd_aval - 1){
                        imprimir(avaliacao2);
                    }else if (cont == qtd_aval){
                        imprimir(avaliacao2);
                    }
                    cont++;
                }
            }
            else System.out.println(LS + "Aluno: " + aluno.getNome() + " não fez nenhuma avaliação.");
        }



    }

}


