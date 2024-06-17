import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ItemTest {

    private Item item;

    @BeforeEach
    void setUp() {
        item = new Item("Produto Teste", 2.0, 10.0);
    }

    @Test
    void testGetProduto() {
        assertEquals("Produto Teste", item.getProduto());
    }

    @Test
    void testGetQuantidade() {
        assertEquals(2.0, item.getQuantidade());
    }

    @Test
    void testGetPrecoUnitario() {
        assertEquals(10.0, item.getPrecoUnitario());
    }

    @Test
    void testGetValorUnitario() {
        assertEquals(20.0, item.getValorUnitario());
    }

    @Test
    void testAplicarDescontoLimite() {
        assertTrue(item.aplicarDesconto(70.0));
    }

    @Test
    void testAplicarDescontoExcedeLimite() {
        assertFalse(item.aplicarDesconto(80.0));
    }
}
