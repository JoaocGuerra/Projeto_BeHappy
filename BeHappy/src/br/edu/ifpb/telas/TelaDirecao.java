package br.edu.ifpb.telas;

import br.edu.ifpb.dominio.Aluno;
import br.edu.ifpb.dominio.Direcao;
import br.edu.ifpb.dominio.Responsavel;
import br.edu.ifpb.ObterValor;
import br.edu.ifpb.padroes.Builder.AlunoBuilder;
import br.edu.ifpb.padroes.Builder.ResponsavelBuilder;
import br.edu.ifpb.padroes.Strategy.selecionarMenuStrategy;

public class TelaDirecao extends ObterValor implements selecionarMenuStrategy {
    private Direcao direcao;

    public TelaDirecao(Direcao direcao) {
        this.direcao = direcao;
    }

    public boolean setStrategyMenu() {
        int opcao = 0;
        String menu = "";
        menu += LS + "====================================" + LS;
        menu += "========== Tela da Direção =========" + LS;
        menu += "====================================" + LS;
        menu += ++opcao + ". Cadastrar Responsável" + LS;
        menu += ++opcao + ". Cadastrar Aluno" + LS;
        menu += ++opcao + ". Relatório" + LS;
        menu += ++opcao + ". Alunos que não avaliaram" + LS;
        menu += ++opcao + ". Listar Responsáveis" + LS;
        menu += ++opcao + ". Listar Alunos" + LS;
        menu += ++opcao + ". Sair" + LS;

        while (true) {
            System.out.println(menu);
            int opcaoEscolhida = obterOpcaoEscolhida("Digite uma opção: ");
            switch (opcaoEscolhida) {
                case 1:
                    Responsavel responsavel = criar_Responsavel();
                    Long cpf = responsavel.getCpf();
                    if (get_responsavel(cpf) == null) {
                        this.direcao.add_Responsavel(responsavel);
                    } else
                        System.out.println("O CPF inserido já está cadastrado.\nVerifique o CPF e tente novamente!");

                    break;
                case 2:
                    Aluno aluno = criar_Aluno();
                    Long CPF_responsavel = aluno.getCpf_responsavel();
                    if (get_responsavel(CPF_responsavel) != null) {
                        Responsavel responsavel_do_aluno = get_responsavel(CPF_responsavel);
                        responsavel_do_aluno.add_Aluno_Responsavel(aluno);
                        this.direcao.add_Aluno(aluno);
                    } else {
                        System.out.println("\nResponsável não encontrado!\nVerifique o CPF e tente novamente!");
                        break;
                    }

                    break;
                case 3:
                    int fez_ava = 0;
                    int nao_fez_ava = 0;
                    for (Aluno aluno1 : direcao.getAlunos()) {
                        if (aluno1.fez_Aval()) {
                            fez_ava++;
                        } else {
                            nao_fez_ava++;
                        }
                    }
                    System.out.println(fez_ava + " Aluno(s) fez/fizeram a avaliação do dia" + LS);
                    System.out.println(nao_fez_ava + " Aluno(s) não fez/fizeram a avaliação do dia" + LS);
                    break;
                case 4:
                    for (Aluno aluno1 : this.direcao.getAlunos()) {
                        if (!aluno1.fez_Aval()) {
                            imprimir(aluno1);
                            System.out.println("Não Avaliou o dia");
                        }
                    }
                    break;
                case 5:
                    for (Responsavel responsavel1 : direcao.getResponsaveis()) {
                        imprimir(responsavel1);
                    }
                    break;
                case 6:
                    for (Aluno aluno1 : direcao.getAlunos()) {
                        imprimir(aluno1);
                    }
                    break;
                case 7:
                    // sair
                    return true;

                default:
                    System.out.println();
                    System.out.println("Erro! Opção desconhecida: " + opcaoEscolhida);
                    System.out.println();
                    break;
            }
        }
    }

    private Responsavel get_responsavel(Long cpf_responsavel) {
        for (Responsavel responsavel : this.direcao.getResponsaveis()) {
            if (responsavel.getCpf().equals(cpf_responsavel)) {
                return responsavel;
            }
        }
        return null;
    }

    private Aluno criar_Aluno() {
        AlunoBuilder alunoBuilder = new AlunoBuilder();
        String menu = "";
        menu += "====================================" + LS;
        menu += "========== Adicionar Aluno =========" + LS;
        menu += "====================================" + LS;
        System.out.println(menu);
        Long mat = obterValorLong("Informe a matrícula do aluno(a): ");
        String nome = obterValorString("Informe o nome do Aluno(a): ");
        int idade = obterValorInteger("Informe a idade do Aluno(a): ");
        Long cpf_responsavel = obterValorLong("Informe o CPF do responsável: ");
        return alunoBuilder.comMatricula(mat).comNome(nome).deIdade(idade).comCpf_responsavel(cpf_responsavel)
                .Builder();
    }

    private Responsavel criar_Responsavel() {
        ResponsavelBuilder responsavelBuilder = new ResponsavelBuilder();
        String menu = "";
        menu += "====================================" + LS;
        menu += "======= Adicionar Responsável ======" + LS;
        menu += "====================================" + LS;
        System.out.println(menu);
        String nome = obterValorString("Informe o nome do responsável: ");
        String email = obterValorString("Informe o email do responsável: ");
        Long cpf = obterValorLong("Informe o cpf do responsável: ");

        return responsavelBuilder.comNome(nome).comEmail(email).comCpf(cpf).Builder();
    }
}
