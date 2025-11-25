package br.pucrs.t2.exemplo.Aplication.Dtos;

import br.pucrs.t2.exemplo.Domain.Entities.AreaFornecedor;
import java.sql.Date;

public class FornecedorDTO {

    private long cod;
    private String nome;
    private Date dataFundacao;
    private AreaFornecedor area;

    public FornecedorDTO() {}

    public FornecedorDTO(long cod, String nome, Date dataFundacao, AreaFornecedor area) {
        this.cod = cod;
        this.nome = nome;
        this.dataFundacao = dataFundacao;
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

    public Date getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public AreaFornecedor getArea() {
        return area;
    }

    public void setArea(AreaFornecedor area) {
        this.area = area;
    }
}
