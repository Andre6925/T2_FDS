package br.pucrs.t2.exemplo.DomainTests.Entities;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.jupiter.api.Test;

import br.pucrs.t2.exemplo.Domain.Entities.AreaFornecedor;
import br.pucrs.t2.exemplo.Domain.Entities.Fornecedor;
import br.pucrs.t2.exemplo.Domain.Entities.Tecnologia;

class TecnologiaTest {

    @Test
    void testConstructorFull() {
        Fornecedor f = new Fornecedor(1L, "Tech", Date.valueOf("2020-01-01"), AreaFornecedor.TI);

        Tecnologia t = new Tecnologia(10, "M1", "Desc", 2000, 2.5, 60, f);

        assertEquals(10, t.getId());
        assertEquals("M1", t.getModelo());
        assertEquals("Desc", t.getDescricao());
        assertEquals(2000, t.getValorBase());
        assertEquals(2.5, t.getPeso());
        assertEquals(60, t.getTemperatura());
        assertEquals(f, t.getFornecedor());
    }

    @Test
    void testSetters() {
        Tecnologia t = new Tecnologia(1, "A", "B", 10, 1.0, 10, (Fornecedor) null);

        Fornecedor f = new Fornecedor();
        t.setId(99);
        t.setModelo("Modelo X");
        t.setDescricao("Nova desc");
        t.setValorBase(999);
        t.setPeso(3.3);
        t.setTemperatura(88);
        t.setFornecedor(f);

        assertEquals(99, t.getId());
        assertEquals("Modelo X", t.getModelo());
        assertEquals("Nova desc", t.getDescricao());
        assertEquals(999, t.getValorBase());
        assertEquals(3.3, t.getPeso());
        assertEquals(88, t.getTemperatura());
        assertEquals(f, t.getFornecedor());
    }

    @Test
    void testToString() {
        Tecnologia t = new Tecnologia(1, "M", "D", 100, 2, 20, (Fornecedor) null);
        String s = t.toString();

        assertTrue(s.contains("id=1"));
        assertTrue(s.contains("modelo=M"));
        assertTrue(s.contains("descricao=D"));
    }
}
