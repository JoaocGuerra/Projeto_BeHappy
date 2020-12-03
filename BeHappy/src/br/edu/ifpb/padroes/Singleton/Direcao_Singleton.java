package br.edu.ifpb.padroes.Singleton;

import br.edu.ifpb.dominio.Direcao;

public class Direcao_Singleton {
    private static Direcao_Singleton instance = null;
    public Direcao direcao = new Direcao(123);

    private Direcao_Singleton() {
    }

    public static Direcao_Singleton getInstance() {
        if (instance == null)
            return new Direcao_Singleton();

        return instance;
    }
}
