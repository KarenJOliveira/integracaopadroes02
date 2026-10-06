public class NotificacaoAguardandoConfirmacao extends Notificacao{
    public NotificacaoAguardandoConfirmacao(String nomeDestinatario, Canal canal)
    {
        super(nomeDestinatario,canal);
    }

    @Override
    public String gerarNotificacao() {
        return this.canal.mensagem() + " para " + this.nomeDestinatario;
    }
}
