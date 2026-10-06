public abstract class Notificacao {
    protected Canal canal;
    protected String nomeDestinatario;

    public Notificacao (String nomeDestinatario, Canal canal)
    {
        this.canal = canal;
        this.nomeDestinatario = nomeDestinatario;
    }

    public void setNomeDestinatario(String nomeDestinatario) {
        this.nomeDestinatario = nomeDestinatario;
    }

    public void setCanal(Canal canal) {
        this.canal = canal;
    }

    public abstract String gerarNotificacao();
}
