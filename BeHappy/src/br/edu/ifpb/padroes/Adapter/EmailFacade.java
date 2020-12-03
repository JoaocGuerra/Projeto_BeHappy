package br.edu.ifpb.padroes.Adapter;

public class EmailFacade {
    public String enviar(String email, String assunto, String mensagem) {
        IEmail servico = new Yahoo();
        //IEmail servico = new Gmail();

        EmailAdapter emailAdapter = new EmailAdapter(servico);

        String output = emailAdapter.enviar(email, assunto, mensagem);

        return output;
    }
}