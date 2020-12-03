package br.edu.ifpb.padroes.Adapter;

import br.edu.ifpb.padroes.Adapter.APIS.GoogleAPI;

public class Gmail implements IEmail {
    private GoogleAPI _googleAPI;

    public Gmail() {
        this._googleAPI = new GoogleAPI();
    }

    @Override
    public String enviar(String email, String assunto, String mensagem) {
        String output = this._googleAPI.sendEmail(email, assunto, mensagem);
        return output;
    }
}