public class PedidoEstadoEmAndamento extends PedidoEstado{
    private PedidoEstadoEmAndamento() {}
    private static PedidoEstadoEmAndamento instance = new PedidoEstadoEmAndamento();
    public static PedidoEstadoEmAndamento getInstance(){
        return instance;
    }

    @Override
    public String getEstado() {
        return "Pedido em andamento";
    }

    @Override
    public boolean aCaminho(Pedido pedido) {
        pedido.setEstado(PedidoEstadoACaminho.getInstance());
        return true;
    }
}
