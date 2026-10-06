import java.util.Observable;
import java.util.Observer;

public class Restaurante implements Observer {
    private String ultimaAtualizacao;
    private Notificacao ultimaNotificacao;
    private RestauranteFactory restaurante;

    public Restaurante(RestauranteFactory restaurante)
    {
        this.restaurante = restaurante;
    }

    public void registrarPedido(Pedido pedido)
    {
        pedido.addObserver(this);
    }

    public void update(Observable observable, Object object1)
    {
        if (!(observable instanceof Pedido pedido)) {
            throw new IllegalArgumentException("O observável deve ser um Pedido.");
        }
        if (!(object1 instanceof Canal canal)) {
            throw new IllegalArgumentException("A atualização do pedido deve informar um Canal.");
        }

        this.ultimaAtualizacao = pedido.toString();

        this.ultimaNotificacao = criarNotificacao(pedido, canal);
    }

    public String getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public Notificacao getUltimaNotificacao() {
        return ultimaNotificacao;
    }

    private Notificacao criarNotificacao(Pedido pedido, Canal canal) {
        PedidoEstado estado = pedido.getEstado();
        String destinatario = pedido.getNomeDestinatario();

        if (estado instanceof PedidoEstadoAguardandoConfirmacao) {
            return new NotificacaoAguardandoConfirmacao(destinatario, canal);
        }
        if (estado instanceof PedidoEstadoConfirmado) {
            return new NotificacaoConfirmacao(destinatario, canal);
        }
        if (estado instanceof PedidoEstadoEmAndamento) {
            return new NotificacaoEmAndamento(destinatario, canal);
        }
        if (estado instanceof PedidoEstadoACaminho) {
            return new NotificacaoACaminho(destinatario, canal);
        }
        if (estado instanceof PedidoEstadoEntregue) {
            return new NotificacaoEntregue(destinatario, canal);
        }
        if (estado instanceof PedidoEstadoCancelado) {
            return new NotificacaoCancelado(destinatario, canal);
        }

        throw new IllegalStateException("Estado do pedido sem notificação correspondente.");
    }
}
