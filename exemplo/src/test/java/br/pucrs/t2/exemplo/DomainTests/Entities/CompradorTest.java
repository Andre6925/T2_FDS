package br.pucrs.t2.exemplo.DomainTests.Entities;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

import br.pucrs.t2.exemplo.Domain.Entities.Comprador;
import br.pucrs.t2.exemplo.Domain.Entities.Fornecedor;
import br.pucrs.t2.exemplo.Domain.Entities.Tecnologia;
import br.pucrs.t2.exemplo.Domain.Entities.Venda;

class CompradorTest {

    @Test
    void testConstructor1() {
        Comprador c = new Comprador(1L, "João", "Brasil", "joao@email");

        assertEquals(1L, c.getCod());
        assertEquals("João", c.getNome());
        assertEquals("Brasil", c.getPais());
        assertEquals("joao@email", c.getEmail());
    }

    @Test
    void testConstructor2() {
        Comprador c = new Comprador("Maria", "Argentina", "maria@email");

        assertNull(c.getCod());
        assertEquals("Maria", c.getNome());
        assertEquals("Argentina", c.getPais());
    }

    @Test
    void testSetters() {
        Comprador c = new Comprador();
        c.setCod(50L);
        c.setNome("Pedro");
        c.setPais("Chile");
        c.setEmail("pedro@x");

        assertEquals(50L, c.getCod());
        assertEquals("Pedro", c.getNome());
        assertEquals("Chile", c.getPais());
        assertEquals("pedro@x", c.getEmail());
    }

    @Test
    void testComprasListManipulation() {
        Comprador c = new Comprador();
        c.compras = new ArrayList<>();

        Tecnologia t = new Tecnologia(2, "M1", "D", 1000, 2, 30,  (Fornecedor) null);
        Venda v = new Venda(10, t, c, false);

        c.compras.add(v);

        assertEquals(1, c.compras.size());
        assertEquals(10, c.compras.get(0).getNum());
    }

    @Test
    void testToString() {
        Comprador c = new Comprador(1L, "João", "Brasil", "email@test");
        String s = c.toString();
        assertTrue(s.contains("país=Brasil"));
        assertTrue(s.contains("email=email@test"));
    }
}
