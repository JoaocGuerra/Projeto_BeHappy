package br.edu.ifpb.padroes.Adapter.APIS;

public class YahooAPI {
    public String sendFromYahoo(String email, String assunto, String mensagem) {
        String output = "";

        output += "Email da API do Yahoo enviado!\n\n";
        output += "\nEmail: " + email;
        output += "\nAssunto: " + assunto;
        output += "\nmensagem: " + mensagem;

        return output;
    }
}