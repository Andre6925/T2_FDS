package br.pucrs.t2.exemplo.AplicationTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.pucrs.t2.exemplo.Aplication.Dtos.VendaDTO;

class VendaDTOTest {

    @Test
    void testConstructorAndGetters() {
        VendaDTO dto = new VendaDTO(
                1001,
                55,
                "Notebook X",
                10,
                "Carlos",
                true
        );

        assertEquals(1001, dto.getNum());
        assertEquals(55, dto.getTecnologiaId());
        assertEquals("Notebook X", dto.getTecnologiaModelo());
        assertEquals(10, dto.getCompradorCod());
        assertEquals("Carlos", dto.getCompradorNome());
        assertTrue(dto.isRemovida());
    }

    @Test
    void testSetters() {
        VendaDTO dto = new VendaDTO();

        dto.setNum(500);
        dto.setTecnologiaId(22);
        dto.setTecnologiaModelo("Modelo Y");
        dto.setCompradorCod(7);
        dto.setCompradorNome("Marcos");
        dto.setRemovida(false);

        assertEquals(500, dto.getNum());
        assertEquals(22, dto.getTecnologiaId());
        assertEquals("Modelo Y", dto.getTecnologiaModelo());
        assertEquals(7, dto.getCompradorCod());
        assertEquals("Marcos", dto.getCompradorNome());
        assertFalse(dto.isRemovida());
    }
}
