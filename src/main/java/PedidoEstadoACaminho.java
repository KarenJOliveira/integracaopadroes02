public class PedidoEstadoACaminho extends PedidoEstado{
    private PedidoEstadoACaminho() {}
    private static PedidoEstadoACaminho instance = new PedidoEstadoACaminho();
    public static PedidoEstadoACaminho getInstance() {
        return instance;
    }

    @Override
    public String getEstado() {
        return "Pedido a caminho";
    }

    @Override
    public boolean entregue(Pedido pedido) {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        return true;
    }
}
