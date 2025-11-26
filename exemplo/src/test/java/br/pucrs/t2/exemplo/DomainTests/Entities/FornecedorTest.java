package br.pucrs.t2.exemplo.DomainTests.Entities;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import br.pucrs.t2.exemplo.Domain.Entities.AreaFornecedor;
import br.pucrs.t2.exemplo.Domain.Entities.Fornecedor;
import br.pucrs.t2.exemplo.Domain.Entities.Tecnologia;

class FornecedorTest {

    @Test
    void testConstructor1() {
        Date d = Date.valueOf("2020-01-01");
        Fornecedor f = new Fornecedor(1L, "Tech", d, AreaFornecedor.TI);

        assertEquals(1L, f.getCod());
        assertEquals("Tech", f.getNome());
        assertEquals(d, f.getDataFundacao());
        assertEquals(AreaFornecedor.TI, f.getArea());
    }

    @Test
    void testConstructor2() {
        Date d = Date.valueOf("2022-01-01");
        Fornecedor f = new Fornecedor("Nova", d);

        assertNull(f.getCod());
        assertEquals("Nova", f.getNome());
        assertEquals(d, f.getDataFundacao());
    }

    @Test
    void testSetters() {
        Fornecedor f = new Fornecedor();
        Date d = Date.valueOf("2021-05-10");

        f.setCod(55L);
        f.setNome("Fornecedor X");
        f.setDataFundacao(d);
        f.setArea(AreaFornecedor.ANDROIDES);

        assertEquals(55L, f.getCod());
        assertEquals("Fornecedor X", f.getNome());
        assertEquals(d, f.getDataFundacao());
        assertEquals(AreaFornecedor.ANDROIDES, f.getArea());
    }

    @Test
    void testAddTecnologia() {
        Fornecedor f = new Fornecedor();
        f.tecnologias = new ArrayList<>();

        Tecnologia t = new Tecnologia(10L, "Model", "Desc", 1000, 1.2, 45, f);
        f.addTecnologia(t);

        assertEquals(1, f.getTecnologias().size());
        assertEquals(f, t.getFornecedor());
    }
}
