package br.edu.ifpb.padroes.Adapter;

public interface IEmail {
    String enviar(String email, String assunto, String mensage);
}