package br.pucrs.t2.exemplo.AplicationTests;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.jupiter.api.Test;

import br.pucrs.t2.exemplo.Aplication.Dtos.FornecedorDTO;
import br.pucrs.t2.exemplo.Domain.Entities.AreaFornecedor;

class FornecedorDTOTest {

    @Test
    void testConstructorAndGetters() {
        Date data = Date.valueOf("2020-01-01");
        FornecedorDTO dto = new FornecedorDTO(5, "TechCorp", data, AreaFornecedor.TI);

        assertEquals(5, dto.getCod());
        assertEquals("TechCorp", dto.getNome());
        assertEquals(data, dto.getDataFundacao());
        assertEquals(AreaFornecedor.TI, dto.getArea());
    }

    @Test
    void testSetters() {
        FornecedorDTO dto = new FornecedorDTO();

        Date data = Date.valueOf("2019-05-10");

        dto.setCod(20);
        dto.setNome("Inova");
        dto.setDataFundacao(data);
        dto.setArea(AreaFornecedor.ALIMENTOS);

        assertEquals(20, dto.getCod());
        assertEquals("Inova", dto.getNome());
        assertEquals(data, dto.getDataFundacao());
        assertEquals(AreaFornecedor.ALIMENTOS, dto.getArea());
    }
}
