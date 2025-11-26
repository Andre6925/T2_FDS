package br.pucrs.t2.exemplo.DomainTests.Entities;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.jupiter.api.Test;

import br.pucrs.t2.exemplo.Domain.Entities.Comprador;
import br.pucrs.t2.exemplo.Domain.Entities.Fornecedor;
import br.pucrs.t2.exemplo.Domain.Entities.Tecnologia;
import br.pucrs.t2.exemplo.Domain.Entities.Venda;

class VendaTest {

    @Test
    void testConstructorFull() {
        Tecnologia t = new Tecnologia(1, "M", "D", 100, 2, 30, (Fornecedor) null);
        Comprador c = new Comprador(2L, "Ana", "Brasil", "ana@email");

        Date d = Date.valueOf("2023-01-10");

        Venda v = new Venda(1001, d, 5000, t, c, true);

        assertEquals(1001, v.getNum());
        assertEquals(d, v.getData());
        assertEquals(5000, v.getValorFinal());
        assertEquals(t, v.getTecnologia());
        assertEquals(c, v.getComprador());
        assertTrue(v.isRemovida());
    }

    @Test
    void testConstructorAutoDate() {
        Tecnologia t = new Tecnologia(1, "M", "D", 10, 1, 20, (Fornecedor) null);
        Comprador c = new Comprador(10L, "Bob", "Chile", "mail");

        Venda v = new Venda(2000, t, c, false);

        assertEquals(2000, v.getNum());
        assertEquals(t, v.getTecnologia());
        assertEquals(c, v.getComprador());
        assertEquals(0.0, v.getValorFinal());
        assertNotNull(v.getData());
    }

    @Test
    void testSetters() {
        Venda v = new Venda();
        Tecnologia t = new Tecnologia(2, "M2", "D2", 100, 2, 20, (Fornecedor) null);
        Comprador c = new Comprador();

        Date d = Date.valueOf("2024-02-02");

        v.setNum(50);
        v.setData(d);
        v.setValorFinal(123.45);
        v.setTecnologia(t);
        v.setComprador(c);
        v.setRemovida(true);

        assertEquals(50, v.getNum());
        assertEquals(d, v.getData());
        assertEquals(123.45, v.getValorFinal());
        assertEquals(t, v.getTecnologia());
        assertEquals(c, v.getComprador());
        assertTrue(v.isRemovida());
    }

    @Test
    void testToString() {
        Venda v = new Venda();
        v.setNum(10);
        v.setData(Date.valueOf("2023-01-01"));
        v.setValorFinal(100);

        String s = v.toString();
        assertTrue(s.contains("num=10"));
        assertTrue(s.contains("valor final=100"));
    }
}
