public abstract class PedidoEstado {
    public abstract String getEstado();

    public boolean aguardarConfirmacao(Pedido pedido){
        return false;
    }

    public boolean confirmar(Pedido pedido){
        return false;
    }

    public boolean emAndamento(Pedido pedido){
        return false;
    }

    public boolean aCaminho(Pedido pedido)
    {
        return false;
    }

    public boolean entregue(Pedido pedido)
    {
        return false;
    }

    public boolean cancelar(Pedido pedido)
    {
        return false;
    }
}
