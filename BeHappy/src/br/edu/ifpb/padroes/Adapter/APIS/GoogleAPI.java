package br.edu.ifpb.padroes.Adapter.APIS;

public class GoogleAPI {
    public String sendEmail(String email, String assunto, String mensagem) {
        String output = "";

        output += "Email da API do Google enviado!\n\n";
        output += "\nEmail: " + email;
        output += "\nAssunto: " + assunto;
        output += "\nmensagem: " + mensagem;

        return output;
    }
}