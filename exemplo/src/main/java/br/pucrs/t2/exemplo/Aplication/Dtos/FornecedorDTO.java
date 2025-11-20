package br.pucrs.t2.exemplo.Aplication.Dtos;

import br.pucrs.t2.exemplo.Domain.Entities.AreaFornecedor;

public class FornecedorDTO {
    private long cod;
    private String nome;
    private AreaFornecedor area;

    public FornecedorDTO() {}

    public FornecedorDTO(long cod, String nome, AreaFornecedor area) {
        this.cod = cod;
        this.nome = nome;
        this.area = area;
    }

    public long getCod() {
        return cod;
    }

    public void setCod(long cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public AreaFornecedor getArea() {
        return area;
    }

    public void setArea(AreaFornecedor area) {
        this.area = area;
    }
}
