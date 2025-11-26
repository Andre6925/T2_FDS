package br.pucrs.t2.exemplo.AplicationTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.pucrs.t2.exemplo.Aplication.Dtos.TecnologiaDTO;

class TecnologiaDTOTest {

    @Test
    void testConstructorAndGetters() {
        TecnologiaDTO dto = new TecnologiaDTO(
                1L,
                "Modelo X",
                "Descrição",
                2000.0,
                2.5,
                70.0,
                99L,
                "TechCorp"
        );

        assertEquals(1L, dto.getId());
        assertEquals("Modelo X", dto.getModelo());
        assertEquals("Descrição", dto.getDescricao());
        assertEquals(2000.0, dto.getValorBase());
        assertEquals(2.5, dto.getPeso());
        assertEquals(70.0, dto.getTemperatura());
        assertEquals(99L, dto.getFornecedorCod());
        assertEquals("TechCorp", dto.getFornecedorNome());
    }

    @Test
    void testSetters() {
        TecnologiaDTO dto = new TecnologiaDTO();

        dto.setId(10L);
        dto.setModelo("Novo Modelo");
        dto.setDescricao("Nova Descrição");
        dto.setValorBase(5000.0);
        dto.setPeso(3.2);
        dto.setTemperatura(80.0);
        dto.setFornecedorCod(123L);
        dto.setFornecedorNome("Fornecedor XYZ");

        assertEquals(10L, dto.getId());
        assertEquals("Novo Modelo", dto.getModelo());
        assertEquals("Nova Descrição", dto.getDescricao());
        assertEquals(5000.0, dto.getValorBase());
        assertEquals(3.2, dto.getPeso());
        assertEquals(80.0, dto.getTemperatura());
        assertEquals(123L, dto.getFornecedorCod());
        assertEquals("Fornecedor XYZ", dto.getFornecedorNome());
    }
}
