package br.edu.ifpb;

import br.edu.ifpb.dominio.Direcao;
import br.edu.ifpb.dominio.TemRepresentacaoTextual;
import java.util.Scanner;

public abstract class ObterValor {

    protected static final String LS = System.lineSeparator();

    protected Direcao direcao;

    protected Scanner sc = new Scanner(System.in);

    protected void imprimir(TemRepresentacaoTextual objeto) {
        System.out.println(objeto.obterRepresentacaoTextual());
    }

    protected Integer obterValorInteger(String mensagemProUsuario) {
        Integer valor = null;
        while(valor == null) {
            System.out.print(mensagemProUsuario);
            try {
                String line = this.sc.nextLine();
                valor = Integer.parseInt(line);
            } catch(NumberFormatException e) {
                System.out.println("Erro! Valor inválido. Tente novamente!");
            }
        }
        return valor;
    }

    protected Long obterValorLong(String mensagemProUsuario) {
        Long valor = null;
        while(valor == null) {
            System.out.print(mensagemProUsuario);
            try {
                String line = this.sc.nextLine();
                valor = Long.parseLong(line);
            } catch(NumberFormatException e) {
                System.out.println("Erro! Valor inválido. Tente novamente!");
            }
        }
        return valor;
    }

    protected Boolean obterValorBoolean(String mensagemProUsuario) {
        Boolean valor = null;
        while(valor == null) {
            System.out.print(mensagemProUsuario);
            String line = this.sc.nextLine();
            if ("Sim".equalsIgnoreCase(line)) {
                line = "True";
            }
            valor = Boolean.parseBoolean(line);
        }
        return valor;
    }

    protected String obterValorString(String mensagemProUsuario) {
        String valor = null;
        while (valor == null) {
            System.out.print(mensagemProUsuario);
            String line = this.sc.nextLine();
            valor = line;
        }
        return valor;
    }

    protected int obterOpcaoEscolhida(String mensagemProUsuario) {
        Integer valor = null;
        while(valor == null) {
            System.out.print(mensagemProUsuario);
            try {
                String line = this.sc.nextLine();
                valor = Integer.parseInt(line);
            } catch(NumberFormatException e) {
                System.out.println("Erro! Opção inválida. Tente novamente!");
            }
        }
        return valor;
    }

}
