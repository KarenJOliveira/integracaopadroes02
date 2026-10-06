public class PedidoEstadoConfirmado extends PedidoEstado{
    private PedidoEstadoConfirmado() {}
    private static PedidoEstadoConfirmado instance = new PedidoEstadoConfirmado();
    public static PedidoEstadoConfirmado getInstance() {
        return instance;
    }

    @Override
    public String getEstado() {
        return "Pedido confirmado";
    }

    @Override
    public boolean emAndamento(Pedido pedido) {
        pedido.setEstado(PedidoEstadoEmAndamento.getInstance());
        return true;
    }

}
