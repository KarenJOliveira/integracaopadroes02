public class PedidoEstadoAguardandoConfirmacao extends PedidoEstado{
    private PedidoEstadoAguardandoConfirmacao() {}
    private static PedidoEstadoAguardandoConfirmacao instance = new PedidoEstadoAguardandoConfirmacao();
    public static PedidoEstadoAguardandoConfirmacao getInstance()
    {
        return instance;
    }

    @Override
    public String getEstado() {
        return "Pedido aguardando confirmação";
    }

    @Override
    public boolean confirmar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoConfirmado.getInstance());
        return true;
    }

    @Override
    public boolean cancelar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        return true;
    }
}
