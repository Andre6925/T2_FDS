package br.pucrs.t2.exemplo.Aplication.Dtos;

import br.pucrs.t2.exemplo.Domain.Entities.Tecnologia;

public class TecnologiaDTO {
    private Long id;
    private String modelo;
    private String descricao;
    private double valorBase;
    private double peso;
    private double temperatura;

    public TecnologiaDTO(Long id, String modelo, String descricao, double valorBase, double peso, double temperatura){
        this.id = id;
        this.modelo = modelo;
        this.descricao = descricao;
        this.valorBase = valorBase;
        this.peso = peso;
        this.temperatura = temperatura;
    }

    public TecnologiaDTO(Tecnologia tecnologia) {
        this(
            tecnologia.getId(),
            tecnologia.getModelo(),
            tecnologia.getDescricao(),
            tecnologia.getValorBase(),
            tecnologia.getPeso(),
            tecnologia.getTemperatura()
        );

    }
    
    public TecnologiaDTO() {}
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Double getValorBase() { return valorBase; }
    public void setValorBase(Double valorBase) { this.valorBase = valorBase; }

    public Double getPeso() { return peso; }
    public void setPeso(Double peso) { this.peso = peso; }

    public Double getTemperatura() { return temperatura; }
    public void setTemperatura(Double temperatura) { this.temperatura = temperatura; }

    public static TecnologiaDTO fromTecnologia(Tecnologia tecnologia){
        return new TecnologiaDTO(tecnologia.getId(), tecnologia.getModelo(), tecnologia.getDescricao(), tecnologia.getValorBase(), tecnologia.getPeso(), tecnologia.getTemperatura());
    }
}