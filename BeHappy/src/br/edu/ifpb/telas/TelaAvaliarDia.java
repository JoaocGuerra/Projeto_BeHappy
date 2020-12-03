package br.edu.ifpb.telas;

import br.edu.ifpb.dominio.Aluno;
import br.edu.ifpb.dominio.Avaliacao;
import br.edu.ifpb.ObterValor;
import br.edu.ifpb.dominio.Responsavel;
import br.edu.ifpb.padroes.Adapter.EmailFacade;
import br.edu.ifpb.padroes.Strategy.selecionarMenuStrategy;
import br.edu.ifpb.padroes.interpreter.EmocoesFacade;

import java.time.LocalDate;

public class TelaAvaliarDia extends ObterValor implements selecionarMenuStrategy {

    private Aluno aluno;
    private Responsavel responsavel_aluno;

    public TelaAvaliarDia(Aluno aluno, Responsavel responsavel) {
        this.aluno = aluno;
        this.responsavel_aluno = responsavel;
    }

    public boolean setStrategyMenu() {
        String emoji;
        String menu = "";
        menu += "====================================" + LS;
        menu += "======== Avalie o seu dia! =========" + LS;
        menu += "====================================" + LS;
        System.out.println(menu);
        while (true) {
            emoji = obterValorString("Informe o emoji (Exs: :) ou :( ou :|): ");
            if (emoji.equals(":)") || emoji.equals(":(") || emoji.equals(":|")) {
                break;
            }
            System.out.println("\nEmoji Incorreto!\n");
        }
        String justificativa = obterValorString("Por que está sentindo-se assim? ");

        EmocoesFacade emocoesFacade = new EmocoesFacade();

        String emojiTraducao = emocoesFacade.execute(emoji);

        System.out.println(emojiTraducao);

        Avaliacao avaliacao = new Avaliacao(LocalDate.now(), emojiTraducao, justificativa);

        aluno.add_Avaliacao(avaliacao);

        /* ENVIAR EMAIL */

        String email = responsavel_aluno.getEmail();

        String assunto = "Avaliação no sistema escolar";

        String mensagem = "";
        mensagem += this.aluno.getNome() + " realizou uma avaliação no sistema escolar.";
        mensagem += "\n\n Avaliação: " + emojiTraducao;
        mensagem += "\n Justificativa: " + justificativa;

        EmailFacade emailFacade = new EmailFacade();

        String output = emailFacade.enviar(email, assunto, mensagem);

        /* FIM */

        System.out.println(LS + "Dia avalidado com sucesso!" + LS);
        System.out.println(LS + output + LS);

        return false;
    }
}