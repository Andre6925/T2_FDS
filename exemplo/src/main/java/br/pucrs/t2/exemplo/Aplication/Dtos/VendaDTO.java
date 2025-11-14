package br.pucrs.t2.exemplo.Aplication.Dtos;

import br.pucrs.t2.exemplo.Domain.Entities.Venda;

public class VendaDTO {

    public long num;
    public TecnologiaDTO tecnologia;
    public CompradorDTO comprador;

    public VendaDTO(Venda venda) {
        this.num = venda.getNum();
        this.tecnologia = new TecnologiaDTO(venda.getTecnologia());
        this.comprador = new CompradorDTO(venda.getComprador());
    }
}