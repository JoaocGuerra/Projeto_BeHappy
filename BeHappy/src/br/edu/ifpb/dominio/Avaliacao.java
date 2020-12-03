package br.edu.ifpb.dominio;

import br.edu.ifpb.ObterValor;

import java.io.Serializable;
import java.time.LocalDate;

public class Avaliacao extends ObterValor implements TemRepresentacaoTextual, Serializable {
    private LocalDate data_av;
    private String emoji;
    private String justificativa;

    public Avaliacao(LocalDate data_av, String emoji, String justificativa) {
        this.data_av = data_av;
        this.emoji = emoji;
        this.justificativa = justificativa;
    }

    public LocalDate getData_av() {
        return data_av;
    }

    public void setData_av(LocalDate data_av) {
        this.data_av = data_av;
    }

    public String getEmoji() {
        return emoji;
    }

    public void setEmoji(String emoji) {
        this.emoji = emoji;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    @Override
    public String obterRepresentacaoTextual() {
        String texto = "";
        texto += LS + "Dia da Avaliação: " + getData_av()
                + LS + "Emoji: " + getEmoji()
                + LS + "Justificativa: " + getJustificativa();
        return texto;
    }
}
