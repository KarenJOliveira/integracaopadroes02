public class NotificacaoConfirmacao extends Notificacao{

    public NotificacaoConfirmacao(String nomeDestinatario, Canal canal)
    {
        super(nomeDestinatario,canal);
    }

    @Override
    public String gerarNotificacao() {
        return this.canal.mensagem() + " para " + this.nomeDestinatario;
    }
}
