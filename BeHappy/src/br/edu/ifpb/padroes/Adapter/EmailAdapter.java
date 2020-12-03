package br.edu.ifpb.padroes.Adapter;

public class EmailAdapter implements IEmail {
    private IEmail _servico;

    public EmailAdapter(IEmail servico) {
        this._servico = servico;
    }

    @Override
    public String enviar(String email, String assunto, String mensagem) {
        String menssagemServico = this._servico.enviar(email, assunto, mensagem);
        return menssagemServico;
    }
}