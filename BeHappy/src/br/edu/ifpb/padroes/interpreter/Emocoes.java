package br.edu.ifpb.padroes.interpreter;

// Classe extendida da abstract expression conforme o diagrama
public class Emocoes extends AbstractExpression {
    @Override
    public String triste() {
        return ":(";
    }

    @Override
    public String alegre() {
        return ":)";
    }

    @Override
    public String zangado() {
        return ":|";
    }
}