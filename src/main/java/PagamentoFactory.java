public class PagamentoFactory {
    public Pagamento obterPagamento(String tipo)
    {
        Class classe = null;
        Object objeto = null;
        try
        {
            classe = Class.forName("Pagamento"+tipo);
            objeto = classe.newInstance();
        }catch (Exception e)
        {
            throw new IllegalArgumentException("Pagamento inexistente");
        }
        if(!(objeto instanceof Pagamento))
        {
            throw new IllegalArgumentException("Pagamento inválido");
        }
        return (Pagamento) objeto;
    }
}
