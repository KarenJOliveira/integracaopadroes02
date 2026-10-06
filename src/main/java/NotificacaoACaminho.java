public class NotificacaoACaminho extends Notificacao{
    public NotificacaoACaminho(String nomeDestinatario, Canal canal)
    {
        super(nomeDestinatario,canal);
    }

    @Override
    public String gerarNotificacao() {
        return this.canal.mensagem() + " para " + this.nomeDestinatario;
    }
}
