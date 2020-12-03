package br.edu.ifpb.padroes.Adapter;

import br.edu.ifpb.padroes.Adapter.APIS.YahooAPI;

public class Yahoo implements IEmail {
    private YahooAPI _yahooAPI;

    public Yahoo() {
        this._yahooAPI = new YahooAPI();
    }

    @Override
    public String enviar(String email, String assunto, String mensagem) {
        String output = this._yahooAPI.sendFromYahoo(email, assunto, mensagem);
        return output;
    }
}