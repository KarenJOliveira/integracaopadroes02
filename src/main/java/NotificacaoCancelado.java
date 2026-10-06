public class NotificacaoCancelado extends Notificacao{
    public NotificacaoCancelado(String nomeDestinatario, Canal canal)
    {
        super(nomeDestinatario,canal);
    }

    @Override
    public String gerarNotificacao() {
        return this.canal.mensagem() + " para " + this.nomeDestinatario;
    }
}
