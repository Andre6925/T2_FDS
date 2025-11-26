package br.pucrs.t2.exemplo.DomainTests.Entities;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import br.pucrs.t2.exemplo.Domain.Entities.Participante;

class ParticipanteTest {

    @Test
    void testConstructorAndGetters() {
        Participante p = new Participante(10L, "Carlos") {};
        assertEquals(10L, p.getCod());
        assertEquals("Carlos", p.getNome());
    }

    @Test
    void testSetters() {
        Participante p = new Participante() {};
        p.setCod(99L);
        p.setNome("Maria");

        assertEquals(99L, p.getCod());
        assertEquals("Maria", p.getNome());
    }
}
