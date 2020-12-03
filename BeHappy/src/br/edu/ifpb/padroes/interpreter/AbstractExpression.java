package br.edu.ifpb.padroes.interpreter;

// Classe abstracta do diagrama
public abstract class AbstractExpression {

    // Método de interpretação conforme o diagrama
    public void interpret(Context context) {
        if (context.getInput().startsWith(this.alegre())) {
            context.setOutput("Alegre");
        }

        if (context.getInput().startsWith(this.triste())) {
            context.setOutput("Triste");
        }

        if (context.getInput().startsWith(this.zangado())) {
            context.setOutput("Zangado");
        }
    }

    public abstract String alegre();

    public abstract String triste();

    public abstract String zangado();
}