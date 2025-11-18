package br.pucrs.t2.exemplo.Aplication.Dtos;

import br.pucrs.t2.exemplo.Domain.Entities.Tecnologia;

public class TecnologiaDTO {
    private long id;
    private String modelo;
    private String descricao;
    private double valorBase;
    private double peso;
    private double temperatura;

    public TecnologiaDTO(long id, String modelo, String descricao, double valorBase, double peso, double temperatura){
        this.id = id;
        this.modelo = modelo;
        this.descricao = descricao;
        this.valorBase = valorBase;
        this.peso = peso;
        this.temperatura = temperatura;
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

    public double getValorBase() {
        return valorBase;
    }


    public String getModelo() {
        return modelo;
    }

    public double getPeso() {
        return peso;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public static TecnologiaDTO fromTecnologia(Tecnologia tecnologia){
        return new TecnologiaDTO(tecnologia.getId(), tecnologia.getModelo(), tecnologia.getDescricao(), tecnologia.getValorBase(), tecnologia.getPeso(), tecnologia.getTemperatura());
    }
}