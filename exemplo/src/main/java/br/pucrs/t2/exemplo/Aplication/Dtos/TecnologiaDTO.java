package br.pucrs.t2.exemplo.Aplication.Dtos;

public class TecnologiaDTO {

    private Long id;
    private String modelo;
    private String descricao;
    private double valorBase;
    private double peso;
    private double temperatura;
    private long fornecedorCod;
    private String fornecedorNome;

    public TecnologiaDTO() {}

    public TecnologiaDTO(long id, String modelo, String descricao,
                         double valorBase, double peso, double temperatura,
                         long fornecedorCod, String fornecedorNome) {
        this.id = id;
        this.modelo = modelo;
        this.descricao = descricao;
        this.valorBase = valorBase;
        this.peso = peso;
        this.temperatura = temperatura;
        this.fornecedorCod = fornecedorCod;
        this.fornecedorNome = fornecedorNome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorBase() {
        return valorBase;
    }

    public void setValorBase(double valorBase) {
        this.valorBase = valorBase;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public long getFornecedorCod() {
        return fornecedorCod;
    }

    public void setFornecedorCod(long fornecedorCod) {
        this.fornecedorCod = fornecedorCod;
    }

    public String getFornecedorNome() {
        return fornecedorNome;
    }

    public void setFornecedorNome(String fornecedorNome) {
        this.fornecedorNome = fornecedorNome;
    }
}
