package br.edu.ifpb.padroes.Facade;

import br.edu.ifpb.armazenamento.Armazenamento;
import br.edu.ifpb.armazenamento.ArmazenamentoBinario;
import br.edu.ifpb.dominio.Direcao;
import br.edu.ifpb.padroes.Strategy.selecionarMenuStrategy;
import br.edu.ifpb.telas.TelaInicial;

public class Facade {
    public void Start() {
        Armazenamento armazenamento = null;
        armazenamento = new ArmazenamentoBinario("Direcao.ser");
        Direcao direcao = armazenamento.recuperar();

        selecionarMenuStrategy selecionarMenuStrategy = new TelaInicial(direcao);
        selecionarMenuStrategy.setStrategyMenu();

        armazenamento.armazenar(direcao);
    }
}
