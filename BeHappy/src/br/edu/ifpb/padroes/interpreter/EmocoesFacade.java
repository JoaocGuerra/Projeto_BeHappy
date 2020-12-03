package br.edu.ifpb.padroes.interpreter;

import java.util.Stack;

// Fachada para processamento da pilha de execução
public class EmocoesFacade {
    // Cria uma pilha para as emoções (Emocoes.java)
    // Aqui pode empilhar várias derivações de emoções
    // Exemplo: Triste.java que contém os métodos: poucoTriste, muitoTriste
    // Usando pilha porque se tiver outras derivações fica mais fácil organizar
    private Stack<AbstractExpression> stackEmocoes;

    public EmocoesFacade() {
        this.init();
    }

    // Método para instanciar a pilha na memória e adicionar as classes de Emoções
    // na pilha
    private void init() {
        this.stackEmocoes = new Stack<AbstractExpression>();
        this.stackEmocoes.push(new Emocoes());
    }

    // Campo do tipo string
    // Aqui quando a classe é chamada, retorna a tradução do emoji
    public String execute(String emocaoAluno) {

        // Instancia o contexto
        Context context = new Context(emocaoAluno);

        // Percore toda a pilha em busca de um input/contexto e
        // seta o output
        // Serve para alterar o contexto de saida (getOutput)
        this.stackEmocoes.forEach(emocao -> emocao.interpret(context));

        // Retorna a string
        return context.getOutput(); // getOutput é uma string, a tradução
    }
}