import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VendaTest {

    private Venda venda;

    @BeforeEach
    void setUp() {
        venda = new Venda("Cliente Teste");
    }

    @Test
    void testGetCliente() {
        assertEquals("Cliente Teste", venda.getCliente());
    }

    @Test
    void testGetSituacaoInicial() {
        assertEquals(Venda.SITUACAO_NAO_INICIADA, venda.getSituacao());
    }

    @Test
    void testVender() {
        venda.vender("Produto Teste", 10.0, 2.0);
        assertEquals(Venda.SITUACAO_EM_ANDAMENTO, venda.getSituacao());
        assertEquals(20.0, venda.getValor());
    }

    @Test
    void testAplicarDescontoVendaNaoIniciada() {
        assertFalse(venda.aplicarDesconto(10));
    }

    @Test
    void testAplicarDesconto() {
        venda.vender("Produto Teste", 10.0, 2.0);
        assertTrue(venda.aplicarDesconto(10));
    }

    @Test
    void testFinalizar() {
        venda.vender("Produto Teste", 10.0, 2.0);
        venda.finalizar();
        assertEquals(Venda.SITUACAO_ENCERRADA, venda.getSituacao());
    }
}
