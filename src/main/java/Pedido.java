import java.util.Observable;

public class Pedido extends Observable {
    private String nomeDestinatario;
    private PedidoEstado estado;
    private Pagamento pagamento;

    public Pedido(String nomeDestinatario, Pagamento pagamento)
    {
        this.pagamento = pagamento;
        this.nomeDestinatario = nomeDestinatario;
        this.estado = PedidoEstadoAguardandoConfirmacao.getInstance();
    }

    public void setEstado(PedidoEstado estado) {
        this.estado = estado;
    }

    public String getNomeDestinatario() {
        return nomeDestinatario;
    }

    public void setNomeDestinatario(String nomeDestinatario) {
        this.nomeDestinatario = nomeDestinatario;
    }

    public PedidoEstado getEstado() {
        return estado;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public boolean aguardarConfirmacao(Pedido pedido){
        return estado.aguardarConfirmacao(this);
    }

    public boolean confirmar(Pedido pedido){
        return estado.confirmar(this);
    }

    public boolean emAndamento(Pedido pedido){
        return estado.emAndamento(this);
    }

    public boolean aCaminho(Pedido pedido)
    {
        return estado.aCaminho(this);
    }

    public boolean entregue(Pedido pedido)
    {
        return estado.entregue(this);
    }

    public void atualizarPedido()
    {
        setChanged();
        notifyObservers();
    }

    public void atualizarPedido(Canal canal)
    {
        setChanged();
        notifyObservers(canal);
    }

     public String toString()
     {
         return "Estado do pedido: " + estado.getEstado();
     }
}
