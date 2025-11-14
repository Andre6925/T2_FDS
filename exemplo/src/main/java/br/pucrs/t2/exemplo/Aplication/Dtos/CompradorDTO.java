package br.pucrs.t2.exemplo.Aplication.Dtos;

import br.pucrs.t2.exemplo.Domain.Entities.Comprador;

public class CompradorDTO {

    public String pais;
    public String email;

    public CompradorDTO(Comprador comprador) {
        this.pais = comprador.getPais();
        this.email = comprador.getEmail();
    }
} 

