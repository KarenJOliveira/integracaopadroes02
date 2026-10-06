import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RestauranteTest {

    @Test
    void deveRetornarSempreAMesmaInstanciaDoGerenciador() {
        assertSame(GerenciadorDePedidos.getInstance(), GerenciadorDePedidos.getInstance());
    }

    @Test
    void deveNotificarPedidoAguardandoConfirmacao() {
        Pedido pedido = new Pedido("Ana", new PagamentoPix());
        Restaurante restaurante = new Restaurante(new RestauranteItaliano());
        GerenciadorDePedidos.getInstance().registrarPedido(restaurante, pedido);
        pedido.atualizarPedido(new CanalEmail());

        assertTrue(restaurante.getUltimaNotificacao() instanceof NotificacaoAguardandoConfirmacao);
        assertEquals("Estado do pedido: Pedido aguardando confirmação", restaurante.getUltimaAtualizacao());
        assertEquals("Email enviado com sucesso para Ana", restaurante.getUltimaNotificacao().gerarNotificacao());
    }

    @Test
    void deveNotificarPedidoConfirmado() {
        Pedido pedido = new Pedido("Ana", new PagamentoPix());
        Restaurante restaurante = new Restaurante(new RestauranteItaliano());
        GerenciadorDePedidos.getInstance().registrarPedido(restaurante, pedido);
        assertTrue(pedido.confirmar(pedido));
        pedido.atualizarPedido(new CanalSMS());

        assertTrue(restaurante.getUltimaNotificacao() instanceof NotificacaoConfirmacao);
        assertEquals("Estado do pedido: Pedido confirmado", restaurante.getUltimaAtualizacao());
        assertEquals("SMS enviado com sucesso para Ana", restaurante.getUltimaNotificacao().gerarNotificacao());
    }

    @Test
    void deveNotificarPedidoEmAndamento() {
        Pedido pedido = new Pedido("Ana", new PagamentoPix());
        Restaurante restaurante = new Restaurante(new RestauranteItaliano());
        GerenciadorDePedidos.getInstance().registrarPedido(restaurante, pedido);
        assertTrue(pedido.confirmar(pedido));
        assertTrue(pedido.emAndamento(pedido));
        pedido.atualizarPedido(new CanalWhatsApp());

        assertTrue(restaurante.getUltimaNotificacao() instanceof NotificacaoEmAndamento);
        assertEquals("Estado do pedido: Pedido em andamento", restaurante.getUltimaAtualizacao());
        assertEquals("WhatsApp enviado com sucesso para Ana", restaurante.getUltimaNotificacao().gerarNotificacao());
    }

    @Test
    void deveNotificarPedidoACaminho() {
        Pedido pedido = new Pedido("Ana", new PagamentoPix());
        Restaurante restaurante = new Restaurante(new RestauranteItaliano());
        GerenciadorDePedidos.getInstance().registrarPedido(restaurante, pedido);
        assertTrue(pedido.confirmar(pedido));
        assertTrue(pedido.emAndamento(pedido));
        assertTrue(pedido.aCaminho(pedido));
        pedido.atualizarPedido(new CanalEmail());

        assertTrue(restaurante.getUltimaNotificacao() instanceof NotificacaoACaminho);
        assertEquals("Estado do pedido: Pedido a caminho", restaurante.getUltimaAtualizacao());
        assertEquals("Email enviado com sucesso para Ana", restaurante.getUltimaNotificacao().gerarNotificacao());
    }

    @Test
    void deveNotificarPedidoEntregue() {
        Pedido pedido = new Pedido("Ana", new PagamentoPix());
        Restaurante restaurante = new Restaurante(new RestauranteItaliano());
        GerenciadorDePedidos.getInstance().registrarPedido(restaurante, pedido);
        assertTrue(pedido.confirmar(pedido));
        assertTrue(pedido.emAndamento(pedido));
        assertTrue(pedido.aCaminho(pedido));
        assertTrue(pedido.entregue(pedido));
        pedido.atualizarPedido(new CanalSMS());

        assertTrue(restaurante.getUltimaNotificacao() instanceof NotificacaoEntregue);
        assertEquals("Estado do pedido: Pedido entregue", restaurante.getUltimaAtualizacao());
        assertEquals("SMS enviado com sucesso para Ana", restaurante.getUltimaNotificacao().gerarNotificacao());
    }

    @Test
    void deveNotificarCancelamentoDoPedido() {
        Pedido pedido = new Pedido("Bruno", new PagamentoCartao());
        Restaurante restaurante = new Restaurante(new RestauranteItaliano());
        GerenciadorDePedidos.getInstance().registrarPedido(restaurante, pedido);

        assertTrue(PedidoEstadoAguardandoConfirmacao.getInstance().cancelar(pedido));
        pedido.atualizarPedido(new CanalWhatsApp());

        assertTrue(restaurante.getUltimaNotificacao() instanceof NotificacaoCancelado);
        assertEquals("Estado do pedido: Pedido cancelado", restaurante.getUltimaAtualizacao());
        assertEquals("WhatsApp enviado com sucesso para Bruno", restaurante.getUltimaNotificacao().gerarNotificacao());
    }

}
