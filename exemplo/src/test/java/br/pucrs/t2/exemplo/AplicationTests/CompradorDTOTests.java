package br.pucrs.t2.exemplo.AplicationTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.pucrs.t2.exemplo.Aplication.Dtos.CompradorDTO;

class CompradorDTOTest {

    @Test
    void testConstructorAndGetters() {
        CompradorDTO dto = new CompradorDTO(10, "Lucas", "Brasil", "lucas@email");

        assertEquals(10, dto.getCod());
        assertEquals("Lucas", dto.getNome());
        assertEquals("Brasil", dto.getPais());
        assertEquals("lucas@email", dto.getEmail());
    }

    @Test
    void testSetters() {
        CompradorDTO dto = new CompradorDTO();

        dto.setCod(20);
        dto.setNome("Pedro");
        dto.setPais("Chile");
        dto.setEmail("pedro@email");

        assertEquals(20, dto.getCod());
        assertEquals("Pedro", dto.getNome());
        assertEquals("Chile", dto.getPais());
        assertEquals("pedro@email", dto.getEmail());
    }
}
