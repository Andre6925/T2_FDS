package br.pucrs.t2.exemplo.Aplication.Dtos;

import br.pucrs.t2.exemplo.Domain.Entities.Tecnologia;

public class TecnologiaDTO {
    private long id;
    private String descricao;
    private double preco;

    public TecnologiaDTO(long id, String descricao, double preco){
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
    }

    public TecnologiaDTO(Tecnologia tecnologia) {
        //TODO Auto-generated constructor stub
    }

    public long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }


    public static TecnologiaDTO fromTecnologia(Tecnologia tecnologia){
        return new TecnologiaDTO(tecnologia.getId(), tecnologia.getDescricao(), tecnologia.getValorBase());
    }
}