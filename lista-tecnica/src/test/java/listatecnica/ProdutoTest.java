package listatecnica;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoTest {

    Produto produto;

    @BeforeEach
    public void setUp() {
        Conjunto roda = new Conjunto("ROD20", "Roda montada", 2);
        roda.addComponente(new Peca("ARO21", "Aro 29", 1, 80.0f, 500));
        roda.addComponente(new Peca("RAI22", "Raio inox", 32, 0.5f, 10));
        roda.addComponente(new Peca("PNE23", "Pneu 29x2.10", 1, 45.0f, 750));

        Conjunto pedivela = new Conjunto("PED31", "Pedivela", 1);
        pedivela.addComponente(new Peca("BRA32", "Braco do pedivela", 2, 30.0f, 250));
        pedivela.addComponente(new Peca("COR33", "Coroa 42 dentes", 1, 60.0f, 500));

        Conjunto transmissao = new Conjunto("TRA30", "Transmissao", 1);
        transmissao.addComponente(pedivela);
        transmissao.addComponente(new Peca("CRR34", "Corrente", 1, 40.0f, 300));

        Conjunto bicicleta = new Conjunto("BIC100", "Bicicleta Urbana", 1);
        bicicleta.addComponente(new Peca("QDR10", "Quadro de aluminio", 1, 250.0f, 2500));
        bicicleta.addComponente(roda);
        bicicleta.addComponente(transmissao);

        produto = new Produto();
        produto.setEstrutura(bicicleta);
    }

    @Test
    void deveRetornarListaTecnicaProduto() {
        assertEquals("Conjunto BIC100: Bicicleta Urbana - qtd: 1 - custo: 692.0\n" +
                "  Peca QDR10: Quadro de aluminio - qtd: 1 - custo: 250.0\n" +
                "  Conjunto ROD20: Roda montada - qtd: 2 - custo: 282.0\n" +
                "    Peca ARO21: Aro 29 - qtd: 1 - custo: 80.0\n" +
                "    Peca RAI22: Raio inox - qtd: 32 - custo: 16.0\n" +
                "    Peca PNE23: Pneu 29x2.10 - qtd: 1 - custo: 45.0\n" +
                "  Conjunto TRA30: Transmissao - qtd: 1 - custo: 160.0\n" +
                "    Conjunto PED31: Pedivela - qtd: 1 - custo: 120.0\n" +
                "      Peca BRA32: Braco do pedivela - qtd: 2 - custo: 60.0\n" +
                "      Peca COR33: Coroa 42 dentes - qtd: 1 - custo: 60.0\n" +
                "    Peca CRR34: Corrente - qtd: 1 - custo: 40.0\n", produto.getListaTecnica());
    }

    @Test
    void deveRetornarCustoTotalProduto() {
        assertEquals(692.0f, produto.getCustoTotal());
    }

    @Test
    void deveRetornarPesoTotalProduto() {
        assertEquals(6940, produto.getPesoTotal());
    }

    @Test
    void deveRetornarTotalPecasProduto() {
        assertEquals(73, produto.getTotalPecas());
    }

    @Test
    void deveMultiplicarCustoConjuntoPelaQuantidade() {
        Componente roda = produto.localizar("ROD20");

        assertEquals(141.0f, roda.getCustoUnitario());
        assertEquals(282.0f, roda.getCustoTotal());
    }

    @Test
    void deveMultiplicarPesoConjuntoPelaQuantidade() {
        Componente roda = produto.localizar("ROD20");

        assertEquals(1570, roda.getPesoUnitario());
        assertEquals(3140, roda.getPesoTotal());
    }

    @Test
    void deveMultiplicarTotalPecasConjuntoPelaQuantidade() {
        assertEquals(68, produto.localizar("ROD20").getTotalPecas());
        assertEquals(3, produto.localizar("PED31").getTotalPecas());
    }

    @Test
    void deveRetornarCustoPecaMultiplicadoPelaQuantidade() {
        Componente raio = produto.localizar("RAI22");

        assertEquals(32, raio.getQuantidade());
        assertEquals(0.5f, raio.getCustoUnitario());
        assertEquals(16.0f, raio.getCustoTotal());
    }

    @Test
    void deveLocalizarPecaNaEstrutura() {
        assertEquals("Corrente", produto.localizar("CRR34").getDescricao());
    }

    @Test
    void deveLocalizarConjuntoNaEstrutura() {
        Componente pedivela = produto.localizar("PED31");

        assertEquals("Pedivela", pedivela.getDescricao());
        assertEquals("Conjunto PED31: Pedivela - qtd: 1 - custo: 120.0\n" +
                "  Peca BRA32: Braco do pedivela - qtd: 2 - custo: 60.0\n" +
                "  Peca COR33: Coroa 42 dentes - qtd: 1 - custo: 60.0\n", pedivela.getEstrutura());
    }

    @Test
    void deveRetornarExcecaoComponenteNaoEncontrado() {
        try {
            produto.localizar("XXX99");
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Componente nao encontrado: XXX99", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoProdutoSemEstrutura() {
        try {
            Produto produtoVazio = new Produto();
            produtoVazio.getListaTecnica();
            fail();
        }
        catch (NullPointerException e) {
            assertEquals("Produto sem estrutura", e.getMessage());
        }
    }
}
