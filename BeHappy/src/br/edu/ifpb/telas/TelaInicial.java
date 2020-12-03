package br.edu.ifpb.telas;

import br.edu.ifpb.dominio.Aluno;
import br.edu.ifpb.dominio.Direcao;
import br.edu.ifpb.dominio.Responsavel;
import br.edu.ifpb.ObterValor;
import br.edu.ifpb.padroes.SimpleFactoryMethod.Interface_SimpleFactoryMethod;
import br.edu.ifpb.padroes.SimpleFactoryMethod.SimpleFactoryMethod;
import br.edu.ifpb.padroes.Strategy.selecionarMenuStrategy;

public class TelaInicial extends ObterValor implements selecionarMenuStrategy {
    private Direcao direcao;

    public TelaInicial(Direcao direcao) {
        this.direcao = direcao;
    }

    public boolean setStrategyMenu() {
        long pass;

        String menu = "";
        menu += LS + "====================================" + LS;
        menu += "=========== Tela Inicial ===========" + LS;
        menu += "====================================" + LS;
        menu += "1 . Direção" + LS;
        menu += "2 . Aluno" + LS;
        menu += "3 . Responsável" + LS;
        menu += "4 . Sair" + LS;

        while (true) {
            System.out.println(menu);
            int opcaoEscolhida = obterOpcaoEscolhida("Digite uma opção: ");
            selecionarMenuStrategy selecionarMenuStrategy = new TelaInicial(direcao);
            switch (opcaoEscolhida) {
                case 1:
                    pass = obterValorLong("Digite a senha: ");
                    if (verifica_Direcao(pass) != null) {
                        selecionarMenuStrategy = new TelaDirecao(this.direcao);
                        selecionarMenuStrategy.setStrategyMenu();
                    } else
                        System.out.println("\nAcesso Negado!\n");
                    break;

                case 2:
                    Interface_SimpleFactoryMethod simpleFactoryMethod = new SimpleFactoryMethod();
                    Responsavel responsavel = simpleFactoryMethod.gerarResponsavel();
                    pass = obterValorLong("Digite a matrícula: ");
                    if (verifica_Aluno(pass) != null) {
                        for (Responsavel responsavel1 : direcao.getResponsaveis()) {
                            if(responsavel1.getCpf().equals(verifica_Aluno(pass).getCpf_responsavel())){
                                responsavel = responsavel1;
                            }
                        }
                        selecionarMenuStrategy = new TelaAluno(verifica_Aluno(pass), responsavel);
                        selecionarMenuStrategy.setStrategyMenu();
                    } else
                        System.out.println("\nAcesso Negado!\n");
                    break;

                case 3:
                    pass = obterValorLong("Digite o cpf: ");
                    if (verifica_Responsavel(pass) != null) {
                        selecionarMenuStrategy = new TelaResponsavel(verifica_Responsavel(pass));
                        selecionarMenuStrategy.setStrategyMenu();
                    } else
                        System.out.println("\nAcesso Negado!\n");
                    break;

                case 4:
                    // sair
                    return false;

                default:
                    System.out.println();
                    System.out.println("Erro! Opção desconhecida: " + opcaoEscolhida);
                    System.out.println();
                    break;
            }


        }
    }

    public Direcao verifica_Direcao(long pass) {
        if (pass == this.direcao.getPass()) {
            return this.direcao;
        } else
            return null;
    }

    public Responsavel verifica_Responsavel(long pass) {
        for (Responsavel responsavel : this.direcao.getResponsaveis()) {
            if (pass == responsavel.getCpf()) {
                return responsavel;
            }
        }
        return null;
    }

    public Aluno verifica_Aluno(long pass) {
        for (Aluno aluno : this.direcao.getAlunos()) {
            if (pass == aluno.getMatricula()) {
                return aluno;
            }
        }
        return null;
    }
}
