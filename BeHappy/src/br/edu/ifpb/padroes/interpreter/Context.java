package br.edu.ifpb.padroes.interpreter;

// Classe contexto para realizar a tradução do emoji
public class Context {
    private String input;
    private String output;

    public Context(String input) {
        this.input = input;
        this.output = null;
    }

    public String getInput() {
        return this.input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return this.output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
}