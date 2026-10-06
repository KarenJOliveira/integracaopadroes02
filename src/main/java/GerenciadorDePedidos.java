public class GerenciadorDePedidos {
    private GerenciadorDePedidos() {}
    private static GerenciadorDePedidos instance = new GerenciadorDePedidos();
    public static GerenciadorDePedidos getInstance()
    {
        return instance;
    }

    public void registrarPedido(Restaurante restaurante, Pedido pedido)
    {
        restaurante.registrarPedido(pedido);
    }
}
